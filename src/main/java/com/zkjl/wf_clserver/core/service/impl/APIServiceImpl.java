package com.zkjl.wf_clserver.core.service.impl;

import com.zkjl.wf_clserver.core.dao.APIDao;
import com.zkjl.wf_clserver.core.entity.JobBean;
import com.zkjl.wf_clserver.core.entity.PageBean;
import com.zkjl.wf_clserver.core.entity.ResourceBean;
import com.zkjl.wf_clserver.core.entity.ResultData;
import com.zkjl.wf_clserver.core.service.APIService;
import com.zkjl.wf_clserver.core.util.GzipUtil;
import com.zkjl.wf_clserver.core.util.MD5Util;
import com.zkjl.wf_clserver.core.util.ResultFactory;
import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class APIServiceImpl implements APIService {

	@Resource
	private APIDao apiDao;


	@Override
	public boolean recordJob(JobBean jobBean) throws Exception {
		String hash = MD5Util.encrypt(jobBean.getUsername() + jobBean.getWord() + jobBean.getWordtype()
				+ StringUtils.join(jobBean.getResources(), ","));
		jobBean.setHash(hash);
		return apiDao.saveJob(jobBean);
	}

	@Override
	public JobBean cacheQuery(JobBean jobBean) throws Exception {
		String hash = MD5Util.encrypt(jobBean.getUsername() + jobBean.getWord() + jobBean.getWordtype()
				+ StringUtils.join(jobBean.getResources(), ","));
		return apiDao.cacheQuery(hash);
	}

	@Override
	public ResultData retrieveData(String jobid, String resid,long version) throws Exception {
		Document doc = apiDao.retrieveData(jobid, resid,version);
		if (doc != null) {
			doc.remove("_id");
		}
		return ResultFactory.createSuccess("", doc);
	}


	@Override
	public List<ResourceBean> userConf(String username) throws Exception {
		return apiDao.userConf(username);
	}

	@Override
	public ResultData saveMaterial(String data) throws Exception {
		String result = GzipUtil.Decompress(data);
		Document doc = Document.parse(result);
		boolean exeresult = apiDao.saveMaterial(doc);
		return ResultFactory.createSuccess(exeresult);
	}

}
