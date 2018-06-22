package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.util.FileUlti;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
@Api(value = "File-API", description = "这是文件上传接口详细信息的描述")
public class FileController {

    /**
     * 图片上传
     * @param req
     * @throws Exception
     */
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @SystemControllerLog(description="图片上传")
    @ResponseBody
    public List<Map<String, Object>> upload(HttpServletRequest req) throws IOException {
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
        }
        return mapList;
    }


}
