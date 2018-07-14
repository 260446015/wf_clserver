package com.zkjl.wf_clserver.core.service.upload;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.entity.FileUploadEntity;
import com.zkjl.wf_clserver.core.exception.CustomerException;
import com.zkjl.wf_clserver.core.repository.es.FileUploadEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
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
    private static final String doc = "doc";

    @Resource
    FileUploadEntityRepository fileUploadEntityRepository;
    @Resource
    private ExecutorService executorService;

    public JSONObject upload(MultipartFile file, HttpServletRequest request) throws IOException, CustomerException {
//        String checkFile = checkFile(file);
        String split = request.getParameter("spliter");
        String textType = request.getParameter("textType");
        List<List<String[]>> datas = analysisGetUploadContent(file, split);
        List<JSONObject> jsonObjects = analysisGetUploadJson(datas);
        List<FileUploadEntity> uploadEntitis = getUploadEntitis(jsonObjects, getFileName(file),textType);
        return saveUploadData(uploadEntitis);
    }

    protected abstract List<List<String[]>> analysisGetUploadContent(Object... args) throws CustomerException;

    protected List<JSONObject> analysisGetUploadJson(List<List<String[]>> datas) {
        List<JSONObject> result = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            List<String[]> datasBySheet = datas.get(i);
            String[] title = {};
            for (int j = 0; j < datasBySheet.size(); j++) {
                if (j == 0) {
                    title = datasBySheet.get(0);
                    continue;
                }
                String[] content = datasBySheet.get(j);
                JSONObject data = new JSONObject();
                for (int k = 0; k < title.length; k++) {
                    data.put(title[k], content[k]);
                }
                result.add(data);
            }
        }
        return result;
    }

    private String getFileName(MultipartFile file) {
        return file.getOriginalFilename();
    }

    private List<FileUploadEntity> getUploadEntitis(List<JSONObject> datas, String source,String textType) {
        List<FileUploadEntity> resultList = new ArrayList<>();
        datas.forEach(action -> {
            FileUploadEntity entity = new FileUploadEntity();
            entity.setContent(action.toJSONString());
            entity.setCreateTime(Calendar.getInstance().getTime());
            String username = "张仁泉";
            try {
//                SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
//                username = user.getName();
            } catch (Exception e) {
//                throw new RuntimeException("用户未登录");
            }
            entity.setUsername(username);
            entity.generatId();
            entity.setSource(source);
            entity.setContentType(textType);
            resultList.add(entity);
        });
        return resultList;
    }

    protected JSONObject saveUploadData(List<FileUploadEntity> list) {
        int remaider = list.size() % 50;
        int number = list.size() / 50;
        int offset = 0;
        List<List<FileUploadEntity>> subList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            List<FileUploadEntity> datas;
            if(remaider > 0){
                datas = list.subList(i * number + offset,(i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                datas = list.subList(i*number+offset,(i+1)*number+offset);
            }
            subList.add(datas);
        }
//        long beginCount = fileUploadEntityRepository.count();
        for (List<FileUploadEntity> datas : subList) {
            executorService.execute(() -> fileUploadEntityRepository.saveAll(datas));
        }
//        executorService.shutdown();
//        try {
//            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        long endCount = fileUploadEntityRepository.count();
        List<FileUploadEntity> collect = list.stream().limit(10).collect(Collectors.toList());
        collect.forEach(action -> action.setContent(action.getContent().replaceAll("\"","'")));
        JSONObject result = new JSONObject();
//        result.put("successCount",endCount - beginCount);
        result.put("successData",collect);
        return result;
    }
}
