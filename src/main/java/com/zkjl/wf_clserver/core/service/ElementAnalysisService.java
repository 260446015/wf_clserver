package com.zkjl.wf_clserver.core.service;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.ApiResult;

/**
 * @author ydw
 * Created on 2018/6/27
 */
public interface ElementAnalysisService {

    JSONObject analysis(String jobId1, String jobId2);

}
