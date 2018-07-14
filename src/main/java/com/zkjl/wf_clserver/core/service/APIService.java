package com.zkjl.wf_clserver.core.service;


import com.zkjl.wf_clserver.core.entity.JobBean;
import com.zkjl.wf_clserver.core.entity.PageBean;
import com.zkjl.wf_clserver.core.entity.ResourceBean;
import com.zkjl.wf_clserver.core.entity.ResultData;

import java.util.List;

public interface APIService {

	List<ResourceBean> userConf(String username) throws Exception;
	
	boolean recordJob(JobBean jobBean) throws Exception;

	JobBean cacheQuery(JobBean jobBean) throws Exception;

	ResultData retrieveData(String jobid, String resid, long version) throws Exception;

	ResultData saveMaterial(String data) throws Exception;

	
	
	
	
	
}
