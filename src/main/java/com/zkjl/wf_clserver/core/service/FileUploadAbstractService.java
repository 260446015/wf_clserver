package com.zkjl.wf_clserver.core.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.common.BeanNameContext;
import com.zkjl.wf_clserver.core.common.UploadEnum;
import com.zkjl.wf_clserver.core.entity.FileUploadEntity;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.exception.UndefinedFileUpload;
import com.zkjl.wf_clserver.core.repository.es.FileUploadEntityRepository;
import com.zkjl.wf_clserver.core.security.ShiroUtil;
import com.zkjl.wf_clserver.core.util.POIUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author ydw
 * Created on 2018/6/26
 */
@Service
public class FileUploadAbstractService {

    private static Logger logger = LoggerFactory.getLogger(POIUtils.class);
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";
    private final static String txt = "txt";
    @Resource
    private BeanNameContext beanNameContext;
    @Resource
    private FileUploadEntityRepository fileUploadEntityRepository;

    public ApiResult upload(MultipartFile file) throws IOException, UndefinedFileUpload {
        String fileType = checkFile(file);
//        Class<?> clazz = selectUploadModel(uploadType);
//        List<Object> list = checkUploadModel(fileType, file, clazz);
//        saveUploadData(list,clazz);
        List<JSONObject> jsonObjects = analysisGetUploadJson(file, fileType);
        String originalFilename = file.getOriginalFilename();
        List<FileUploadEntity> entities = getUploadEntitis(jsonObjects,originalFilename);
        fileUploadEntityRepository.saveAll(entities);
        return null;
    }

    private List<FileUploadEntity> getUploadEntitis(List<JSONObject> datas,String source) {
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
                e.printStackTrace();
            }
            entity.setUsername(username);
            entity.generatId();
            entity.setSource(source);
            resultList.add(entity);
        });
        return resultList;
    }

    private List<JSONObject> analysisGetUploadJson(MultipartFile file, String fileType) throws IOException, UndefinedFileUpload {
        List<String[]> list = null;
        List<JSONObject> resultList = new ArrayList<>();
        switch (fileType) {
            case "txt":
                list = POIUtils.readTxt(file,"~");//传参
                break;
            case "excel":
                list = POIUtils.readExcel(file);
                break;
            default:
        }
        if (null == list) {
            throw new UndefinedFileUpload("未定义的文件读取");
        }
        List<String[]> titles = POIUtils.readExcelTitleAll(file, 1);
        for (int i = 0; i < titles.size(); i++) {
            String[] title = titles.get(i);
            List<String[]> values = POIUtils.readExcelBySheet(file, i,2);//内容起始行，应当需要接口传值
            for (String[] arr : values) {
                JSONObject jsonObject = new JSONObject();
                for (int j = 0; j < arr.length; j++) {
                    jsonObject.put(title[j], arr[j]);
                }
                resultList.add(jsonObject);
            }
        }
        return resultList;
    }

    protected Class<?> selectUploadModel(String uploadType) {
        return UploadEnum.getSelectModel(uploadType);
    }

    protected List<Object> checkUploadModel(String fileType, MultipartFile file, Class<?> clazz) throws IOException, UndefinedFileUpload {
        List<String[]> list = null;
        List<Object> resultList = new ArrayList<>();
        switch (fileType) {
            case "txt":
                list = POIUtils.readTxt(file,"~");
                break;
            case "excel":
                list = POIUtils.readExcel(file);
                break;
            default:
        }
        if (null == list) {
            throw new UndefinedFileUpload("未定义的文件读取");
        }
        for (String[] action : list) {
            int j = 0;
            try {
                Object o = clazz.newInstance();
                Method[] declaredMethods = clazz.getDeclaredMethods();
                for (int i = 0; i < declaredMethods.length; i++) {
                    Method declaredMethod = declaredMethods[i];
                    if (declaredMethod.getName().startsWith("set") && !declaredMethod.getName().equals("setId")) {
                        declaredMethod.invoke(o, action[j++]);
                    }
                }
                resultList.add(o);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }


    private MongoRepository doScanner(String packageName, Class<?> clazz) {
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(packageName + "." + file.getName().substring(0, file.getName().indexOf(".")), clazz);
            } else {
                try {
                    Class<?> targetClass = Class.forName(packageName + "." + file.getName().substring(0, file.getName().indexOf(".")));
                    Type[] type = targetClass.getGenericInterfaces();
                    // 强转为“参数化类型”
                    //ParameterizedType参数化类型，即泛型
                    Type type1 = type[0];
                    ParameterizedType pt = (ParameterizedType) type1;
                    // 获取参数化类型中，实际类型的定义
                    Type[] ts = pt.getActualTypeArguments();
                    // 转换
                    Type entityType = ts[0];
                    if (entityType.getTypeName().equals(clazz.getName())) {
                        return (MongoRepository) beanNameContext.getBean(targetClass);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    protected void saveUploadData(List<Object> list, Class<?> clazz) {
        MongoRepository mongoRepository = doScanner("com.zkjl.wf_clserver.core.repository.kklc", clazz);
        mongoRepository.saveAll(list);
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
            if (fileName.endsWith(txt)) {
                logger.info("正在对txt文件进行读取");
                return txt;
            } else {
                logger.error(fileName + "不是excel文件或txt文件");
                throw new IOException(fileName + "不是excel文件或txt文件");
            }
        }
        return "excel";
    }

}
