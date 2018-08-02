package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.entity.ResultData;
import com.zkjl.wf_clserver.core.service.APIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Controller
public class CustomController {

    @Value(value = "${web.upload-path}")
    private String filePath;

    @Resource
    private APIService apiService;

    @GetMapping(value = "/apis/download")
    public void download(HttpServletResponse resp) throws Exception {

        /**创建一个临时压缩文件，我们会把文件流全部注入到这个文件中，这里的文件你可以自定义是.rar还是.zip**/
        File file = new File(filePath+"/PloverCrawler.zip");
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        resp.reset();
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Disposition", "attachment;filename=plower.zip");
        resp.addHeader("Content-Length", "" + file.length());
        resp.setContentType("APPLICATION/OCTET-STREAM");
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();

    }

}
