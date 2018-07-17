package com.zkjl.wf_clserver.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.entity.JobBean;
import com.zkjl.wf_clserver.core.entity.ResourceBean;
import com.zkjl.wf_clserver.core.entity.ResultData;
import com.zkjl.wf_clserver.core.service.APIService;
import com.zkjl.wf_clserver.core.util.ResultFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 处理API请求
 * 
 * @author Jason.zhang
 * @mobile 18282600855
 * @since 2017/10/10
 * 
 */
@Controller
public class APIController extends BaseController {

	@Resource
	private APIService apiService;

	/**
	 * 创建任务
	 * 
	 * @param request
	 * @param jobBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/api/createJob")
	@SystemControllerLog(description = "创建爬虫任务")
	public @ResponseBody
	ResultData createJob(HttpServletRequest request, HttpServletResponse response, @RequestBody JobBean jobBean) throws Exception {
		Map<String, Object> resultData = new LinkedHashMap<>();
		String userName = this.getCurrentUser().getUsername();
		String ip = this.getClientIP(request);
		jobBean.setIp(ip);
		jobBean.setUsername(userName);
		jobBean.setExetime(System.currentTimeMillis() / 1000);
		JobBean cacheJob = apiService.cacheQuery(jobBean);
		if (cacheJob != null) {
			jobBean.setJobid(cacheJob.getJobid());
		} else {
			jobBean.setJobid(UUID.randomUUID().toString());
			List<ResourceBean> resList = apiService.userConf(userName);
			resList.retainAll(jobBean.getResources());
			for (String id : jobBean.getResources()) {
				ResourceBean resouceBean = new ResourceBean();
				resouceBean.setId(id);
				if (!resList.contains(resouceBean)) {
					resList.add(resouceBean);
				}
			}
			resultData.put("resources", resList);
		}
		apiService.recordJob(jobBean);
		resultData.put("iscache", cacheJob != null);
		resultData.put("jobinfo", jobBean);
		return ResultFactory.createSuccess("成功创建任务！", resultData);
	}

	/**
	 * 更新任务
	 *
	 * @param request
	 * @param jobBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/api/updateJob")
	@SystemControllerLog(description = "更新爬虫任务")
	public @ResponseBody
	ResultData updateJob(HttpServletRequest request, @RequestBody JobBean jobBean) throws Exception {
		Map<String, Object> resultData = new LinkedHashMap<>();
		String userName = this.getCurrentUser().getUsername();
		String ip = this.getClientIP(request);
		jobBean.setIp(ip);
		jobBean.setUsername(userName);
		jobBean.setExetime(System.currentTimeMillis() / 1000);
		apiService.recordJob(jobBean);
		List<ResourceBean> resList = apiService.userConf(userName);
		resList.retainAll(jobBean.getResources());
		for (String id : jobBean.getResources()) {
			ResourceBean resouceBean = new ResourceBean();
			resouceBean.setId(id);
			if (!resList.contains(resouceBean)) {
				resList.add(resouceBean);
			}
		}
		resultData.put("resources", resList);
		resultData.put("jobinfo", jobBean);
		return ResultFactory.createSuccess("成功创建任务！", resultData);
	}

	/**
	 * 获取数据
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/api/retrieveData")
	public @ResponseBody
	ResultData retrieveData(@RequestBody String data) throws Exception {
		JSONObject json = JSONObject.parseObject(data);
		long version=0;
		if(json.containsKey("version")){
			version=json.getLongValue("version");
		}
		return apiService.retrieveData(json.getString("jobid"), json.getString("resid"),version);
	}


    /**
     * 给采集程序提供数据上传接口
     *
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("/api/material")
    public @ResponseBody
    ResultData material(@RequestBody String data) throws Exception {
        System.out.println(data);
        return apiService.saveMaterial(data);
    }

}
