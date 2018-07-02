package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.exception.UndefinedFileUpload;
import com.zkjl.wf_clserver.core.service.FileUploadAbstractService;
import com.zkjl.wf_clserver.core.service.LogService;
import com.zkjl.wf_clserver.core.util.FileUlti;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/file")
@Api(value = "File-API", description = "这是文件上传接口详细信息的描述")
public class FileController {

    protected Validator validator;
    @Resource
    private LogService logService;
    @Resource
    private FileUploadAbstractService fileUploadAbstractService;
    /**
     * 图片上传
     * @param req
     * @throws Exception
     */
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @SystemControllerLog(description="图片上传")
    @ResponseBody
    public List<Map<String, Object>> upload(HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)req;
        List<Map<String, Object>> mapList=new ArrayList<>();
        List multipartFiles = multipartRequest
                .getFiles("file");// 得到所有的文件
        for (int i = 0; i < multipartFiles.size(); i++) {
            Map<String, Object> map=new HashMap<>();
            MultipartFile multipartFile = (MultipartFile)multipartFiles.get(i);
            if (multipartFile.getSize() <= 0L) {
                return null;
            }
            String fileUrl= FileUlti.uploadImg(req,multipartFile);
            map.put("url", fileUrl);
            mapList.add(map);
        }
        return mapList;
    }
    /**
     * Excel上传
     * @throws Exception
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @SystemControllerLog(description="Excel上传")
    @ResponseBody
    public ApiResult uploadExcel(@RequestParam("fileName") MultipartFile file)  {
        try {
            fileUploadAbstractService.upload(file);
        } catch (UndefinedFileUpload undefinedFileUpload) {
            undefinedFileUpload.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
