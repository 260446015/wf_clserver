package com.zkjl.wf_clserver.core.service.upload.impl;

import com.zkjl.wf_clserver.core.exception.CustomerException;
import com.zkjl.wf_clserver.core.service.upload.UploadAbstractService;
import com.zkjl.wf_clserver.core.util.POIUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ydw
 * Created on 2018/7/10
 */
@Service
public class WordUpload extends UploadAbstractService{
    @Override
    protected List<List<String[]>> analysisGetUploadContent(Object... args) throws CustomerException {
        MultipartFile file = (MultipartFile) args[0];
        List<List<String[]>> result = new ArrayList<>();
        List<String[]> list = POIUtils.readWord(file);
        result.add(list);
        return result;
    }
}
