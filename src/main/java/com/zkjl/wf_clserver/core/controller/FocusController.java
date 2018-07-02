package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.service.FocusService;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/** 重点关注信息查询 */
@Controller
@RequestMapping("/focus")
public class FocusController {

	@Resource
	private FocusService focusService;
	
	private static final Logger log = Logger.getLogger(FocusController.class);// 日志文件


	/**
	 * 重点关注信息
	 */
	@GetMapping("/get")
	@SystemControllerLog(description="人员档案-重点关注信息查询")
	@ApiOperation(value = "重点关注", httpMethod = "GET")
	public Map<String, Object> get(String idCard) throws Exception {
		Map<String, Object> mapList=new HashMap<>();
		//查询违法犯罪信息
		Map<String, Object> crimeInfors=focusService.getCrimeInfor(idCard);
		mapList.put("crimeInfors", crimeInfors);
		//查询在逃人员信息
		Map<String, Object> fugitiveInfors=focusService.getFugitiveInfor(idCard);
		mapList.put("fugitiveInfors", fugitiveInfors);
		//查询涉毒信息
		Map<String, Object> drugAddictsInfo=focusService.getDrugAddictsInfo(idCard);
		mapList.put("drugAddictsInfo", drugAddictsInfo);
		//查询闭环系统信息
		Map<String, Object> closedLoop=focusService.getClosedLoop(idCard);
		mapList.put("closedLoop", closedLoop);
		//查询维稳重点人信息
		Map<String, Object> stabilityPoint=focusService.getStabilityPoint(idCard);
		mapList.put("stabilityPoint", stabilityPoint);
		return mapList;
	}
	
	
}
