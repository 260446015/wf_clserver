package com.zkjl.wf_clserver.core.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUlti {

    public static String uploadImg(HttpServletRequest request,MultipartFile file) {
        if (null != file) {
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
            String myFileName = file.getOriginalFilename();// 文件原名称
            String basePath = request.getSession().getServletContext().getRealPath("/");;
            //String pat=FileProperties.getFilePath()+"/src/main/webapp/";//获取文件保存路径
            String sqlPath="images/upload/"+dateformat.format(new Date())+"/";

            File fileDir=new File(basePath+sqlPath);
            if (!fileDir.exists()) { //如果不存在 则创建
                fileDir.mkdirs();
            }
            String path=basePath+sqlPath+myFileName;
            File localFile = new File(path);
            try {
                file.transferTo(localFile);
                return sqlPath+myFileName;
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            System.out.println("文件为空");
        }
        return null;
    }
}
