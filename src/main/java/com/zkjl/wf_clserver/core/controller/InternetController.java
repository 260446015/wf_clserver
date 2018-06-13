package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.service.InternetService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/** 社会信息查询 */
@Controller
@RequestMapping("/internet")
public class InternetController {

	@Resource
	private InternetService internetService;

	private static final Logger log = Logger.getLogger(InternetController.class);// 日志文件

	/**
	 * 社会信息查询
	 */
	@RequestMapping("/get")
	@SystemControllerLog(description="人员档案-互联网信息查询")
	public Map<String, Object> get(HttpServletRequest req,String mobile) throws Exception {
		Map<String, Object> mapList=new HashMap<>();
		//查询宽带信息
		Map<String, Object> broadbandMap=internetService.getBroadband(mobile);
		mapList.put("broadbandList", broadbandMap);
		//查询qq信息
		Map<String, Object> workersMap=internetService.getQQList(mobile);
		mapList.put("workers", workersMap);
		//查询微信信息
		Map<String, Object> wechatMap=internetService.getWechatList(mobile);
		mapList.put("wechatList", wechatMap);
		//查询微博信息
		Map<String, Object> twitterMap=internetService.getTwitterList(mobile);
		mapList.put("twitterList", twitterMap);
		//查询论坛信息
		Map<String, Object> forumMap=internetService.getForumList(mobile);
		mapList.put("forumsList", forumMap);
		return mapList;
	}
	
}
