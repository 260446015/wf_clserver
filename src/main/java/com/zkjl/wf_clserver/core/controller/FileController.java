package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.entity.FileUploadEntity;
import com.zkjl.wf_clserver.core.exception.CustomerException;
import com.zkjl.wf_clserver.core.service.upload.FileService;
import com.zkjl.wf_clserver.core.util.FileUlti;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageImpl;
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
public class FileController extends BaseController {

    protected Validator validator;
    @Resource
    private FileService fileService;
    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 图片上传
     *
     * @param req
     * @throws Exception
     */
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> upload(HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
        List<Map<String, Object>> mapList = new ArrayList<>();
        List multipartFiles = multipartRequest
                .getFiles("file");// 得到所有的文件
        for (int i = 0; i < multipartFiles.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            MultipartFile multipartFile = (MultipartFile) multipartFiles.get(i);
            if (multipartFile.getSize() <= 0L) {
                return null;
            }
            String fileUrl = FileUlti.uploadImg(req, multipartFile);
            map.put("url", fileUrl);
            mapList.add(map);
        }
        return mapList;
    }

    /**
     * Excel上传
     *
     * @throws Exception
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @SystemControllerLog(description = "Excel上传")
    @ResponseBody
    public ApiResult uploadExcel(HttpServletRequest req, HttpServletResponse response) {
        String uploadid = req.getParameter("uploadid");
        if ("1".equals(uploadid)) {
            return success("等待uploadid改变");
        }
        String split = req.getParameter("spliter");
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
            List multipartFiles = multipartRequest
                    .getFiles("file");// 得到所有的文件
            MultipartFile multipartFile = null;
            for (int i = 0; i < multipartFiles.size(); i++) {
                multipartFile = (MultipartFile) multipartFiles.get(i);
                if (multipartFile.getSize() <= 0L) {
                    return null;
                }
            }
            return success(fileService.upload(multipartFile, req));
        } catch (IOException e) {
            return error("导入失败:" + e.getMessage());
        } catch (CustomerException e) {
            return error("导入失败:" + e.getMessage());
        }
//        return success("导入成功!");
    }

    /**
     * Excel上传
     *
     * @throws Exception
     */
    @GetMapping(value = "/upload")
    @ResponseBody
    public ApiResult search(String search, int pageNum, int pageSize) {
        PageImpl<FileUploadEntity> page = null;
        try {
            page = fileService.search(search, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return successPages(page);
    }

    @DeleteMapping(value = "{source}")
    @ResponseBody
    public ApiResult delete(@PathVariable String source){
        boolean flag = false;
        try {
            flag = fileService.delete(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success(flag);
    }
}
