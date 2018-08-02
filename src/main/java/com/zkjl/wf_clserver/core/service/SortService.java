package com.zkjl.wf_clserver.core.service;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.dto.req.SortPage;
import com.zkjl.wf_clserver.core.exception.CustomerException;

public interface SortService {

    JSONObject sort(SortPage page) throws CustomerException;
}
