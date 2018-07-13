package com.zkjl.wf_clserver.core.util;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUlti {

    public static String uploadImg(HttpServletRequest request,MultipartFile file) {
        if (null != file) {
            String filePath = "";
            try {
                String myFileName = file.getOriginalFilename();
                filePath = "D:\\图片虚拟目录\\"+myFileName;
                File localFile = new File(filePath);
                file.transferTo(localFile);
                return "/static/upload/"+myFileName;
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("文件为空");
        }
        return null;
    }
}
