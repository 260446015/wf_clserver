package com.zkjl.wf_clserver.core.service.upload;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.entity.FileUploadEntity;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.exception.CustomerException;
import com.zkjl.wf_clserver.core.repository.es.FileUploadEntityRepository;
import org.apache.shiro.SecurityUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author ydw
 * Created on 2018/7/2
 */
public abstract class UploadAbstractService {

    private static Logger logger = LoggerFactory.getLogger(UploadAbstractService.class);

    private static final String xls = "xls";
    private static final String xlsx = "xlsx";
    private static final String txt = "txt";
    private static final String CSV = "CSV";

    @Resource
    FileUploadEntityRepository fileUploadEntityRepository;
    @Resource
    private ExecutorService executorService;

    public List<FileUploadEntity> upload(MultipartFile file) throws IOException, CustomerException {
        String checkFile = checkFile(file);
        List<List<String[]>> datas = analysisGetUploadContent(file,"`");
        List<JSONObject> jsonObjects = analysisGetUploadJson(datas);
        List<FileUploadEntity> uploadEntitis = getUploadEntitis(jsonObjects, getFileName(file));
        return saveUploadData(uploadEntitis);
    }

    public static String checkFile(MultipartFile file) throws IOException {
        //判断文件是否存在
        if (null == file) {
            logger.error("文件不存在！");
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
            if (fileName.endsWith(txt) || fileName.endsWith(CSV)) {
                logger.info("正在对非excel文件进行读取");
                return txt;
            } else {
                logger.error(fileName + "不是excel文件或txt文件");
                throw new IOException(fileName + "不是excel文件或txt文件");
            }
        }
        return "excel";
    }

    protected abstract List<List<String[]>> analysisGetUploadContent(Object... args) throws CustomerException;

    protected List<JSONObject> analysisGetUploadJson(List<List<String[]>> datas){
        List<JSONObject> result = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            List<String[]> datasBySheet = datas.get(i);
            String[] title = {};
            for (int j = 0; j < datasBySheet.size(); j++) {
                if(j == 0){
                    title = datasBySheet.get(0);
                    continue;
                }
                String[] content = datasBySheet.get(j);
                JSONObject data = new JSONObject();
                for (int k = 0; k < title.length; k++) {
                    data.put(title[k],content[k]);
                }
                result.add(data);
            }
        }
        return result;
    }

    private String getFileName(MultipartFile file){
        return file.getOriginalFilename();
    }

    private List<FileUploadEntity> getUploadEntitis(List<JSONObject> datas, String source) {
        List<FileUploadEntity> resultList = new ArrayList<>();
        datas.forEach(action -> {
            FileUploadEntity entity = new FileUploadEntity();
            entity.setContent(action.toJSONString());
            entity.setCreateTime(Calendar.getInstance().getTime());
            String username = "";
            try {
                SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
                username = user.getName();
            } catch (Exception e) {
                throw new RuntimeException("用户未登录");
            }
            entity.setUsername(username);
            entity.generatId();
            entity.setSource(source);
            resultList.add(entity);
        });
        return resultList;
    }

    protected List<FileUploadEntity> saveUploadData(List<FileUploadEntity> list) {
//        List<String> ids = list.stream().map(action -> action.getId()).collect(Collectors.toList());
//        List<FileUploadEntity> datas = fileUploadEntityRepository.findByIdIn(ids);
//        if(datas.size() > 0){
//            executorService.execute(() -> fileUploadEntityRepository.saveAll(datas));
//        }
        fileUploadEntityRepository.saveAll(list);
        return null;
    }
}
