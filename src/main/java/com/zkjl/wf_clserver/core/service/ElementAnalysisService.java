package com.zkjl.wf_clserver.core.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ydw
 * Created on 2018/6/27
 */
public interface ElementAnalysisService {

    JSONObject analysis(String word1, String word2);

}
