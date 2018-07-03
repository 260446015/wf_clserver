package com.zkjl.wf_clserver.core.service.upload.impl;

import com.zkjl.wf_clserver.core.service.upload.UploadAbstractService;
import com.zkjl.wf_clserver.core.util.POIUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ydw
 * Created on 2018/7/2
 */
@Service
public class TxtUpload extends UploadAbstractService {
    @Override
    protected List<List<String[]>> analysisGetUploadContent(Object... args) {
        MultipartFile file = (MultipartFile) args[0];
        String split = (String) args[1];
        List<List<String[]>> result = new ArrayList<>();
        List<String[]> list = POIUtils.readTxt(file, split);
        result.add(list);
        return result;
    }
}
