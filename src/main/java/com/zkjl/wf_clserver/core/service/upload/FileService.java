package com.zkjl.wf_clserver.core.service.upload;

import com.zkjl.wf_clserver.core.entity.FileUploadEntity;
import com.zkjl.wf_clserver.core.exception.CustomerException;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author ydw
 * Created on 2018/7/2
 */
public interface FileService {

    void upload(MultipartFile file) throws IOException, CustomerException;

    PageImpl<FileUploadEntity> search(String search, int pageNum, int pageSize);
}
