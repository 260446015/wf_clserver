package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.service.SocialService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/** 社会信息查询 */
@Controller
@RequestMapping("/social")
public class SocialController {

	@Resource
	private SocialService socialService;
	
	private static final Logger log = Logger.getLogger(SocialController.class);// 日志文件


	/**
	 * 社会信息查询
	 */
	@RequestMapping("/get")
	@SystemControllerLog(description="人员档案-社会信息查询")
	public Map<String, Object> get(HttpServletRequest req,String idCard) throws Exception {
		Map<String, Object> mapList=new HashMap<>();
		//查询银行信息
		Map<String, Object> bankInfoMap=socialService.getBankInfo(idCard);
		mapList.put("bankInfoList", bankInfoMap);
		//查询职工信息
		Map<String, Object> workersMap=socialService.getWorkers(idCard);
		mapList.put("workersList", workersMap);
		//查询医保信息
		Map<String, Object> medicalInsuranceMap=socialService.getMedicalInsurance(idCard);
		mapList.put("medicalInsuranceList", medicalInsuranceMap);
		//查询公积金信息
		Map<String, Object> fundMap=socialService.getFund(idCard);
		mapList.put("fundList", fundMap);
		//查询纳税人信息
		//查询水电汽暖信息
		return mapList;
	}
	
	
}
