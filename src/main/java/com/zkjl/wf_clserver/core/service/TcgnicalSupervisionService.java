package com.zkjl.wf_clserver.core.service;


import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public interface TcgnicalSupervisionService extends Serializable {
	/** 查询 */
	public JSONObject find(ArrayList<String> list, String isQuestion);

	/** 查询页面下拉框内容 */
	public JSONObject findLables();

}
