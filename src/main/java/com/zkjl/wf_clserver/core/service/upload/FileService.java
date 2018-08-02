package com.zkjl.wf_clserver.core.service.upload;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.entity.FileUploadEntity;
import com.zkjl.wf_clserver.core.exception.CustomerException;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ydw
 * Created on 2018/7/2
 */
public interface FileService {

    JSONObject upload(MultipartFile file, HttpServletRequest request) throws IOException, CustomerException;

    PageImpl<FileUploadEntity> search(String search, int pageNum, int pageSize);

    boolean delete(String source);

    String uploadImg(HttpServletRequest req, MultipartFile multipartFile);

    PageImpl<?> findUploadData(String username, Integer pageNum, Integer pageSize);

    Long findUploadCount(String username);
}
