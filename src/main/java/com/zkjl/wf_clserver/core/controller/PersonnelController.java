package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.service.ContactService;
import com.zkjl.wf_clserver.core.service.PersonnelInfoService;
import com.zkjl.wf_clserver.core.util.OriginTest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/** 人员查询 */
@Controller
@RequestMapping("/personnel")
public class PersonnelController {

	@Resource
	private PersonnelInfoService personnelInfoService;
	
	@Resource
	private ContactService contactService;
	private static final Logger log = Logger.getLogger(PersonnelController.class);// 日志文件


	/**
	 * 查询
	 */
	@RequestMapping("/list")
	@SystemControllerLog(description="智能搜索-一键查询")
	public Map<String, Object> list(HttpServletRequest req,String keyword) throws Exception {
		Map<String, Object> map=personnelInfoService.search(keyword);
		return map;
	}

	/**
	 * 基本情况
	 */
	@RequestMapping("/basic/info")
	@SystemControllerLog(description="人员档案-基本情况")
	public Map<String, Object> getBasicInfo(HttpServletRequest req,String idCard) throws Exception {
		Map<String, Object> mapList=new HashMap<>();
		Map<String, Object> dirverMap=personnelInfoService.getDriverByIdCard(idCard);
		mapList.put("dirverList", dirverMap.get("list"));
		Map<String, Object> passportMap=personnelInfoService.getPassportByIdCard(idCard);
		mapList.put("passportList", passportMap.get("list"));
		Map<String, Object> workMap=personnelInfoService.getWorkByIdCard(idCard);
		mapList.put("workList", workMap.get("list"));
		return mapList;
	}
	
	/**
	 * 联系方式
	 */
	@RequestMapping("/contact/list")
	@SystemControllerLog(description="人员档案-联系方式")
	public Map<String, Object> getContactList(HttpServletRequest req,String idCard) throws Exception {
		Map<String, Object> map=contactService.getListByIdCard(idCard);
		return map;
	}
	
	/**
	 * 邻居关系
	 */
	@RequestMapping("/neighbor/list")
	@SystemControllerLog(description="人员档案-邻居关系")
	public Map<String, Object> getNeighborList(HttpServletRequest req,String address) throws Exception {
		Map<String, Object> map=new HashMap<>();
		Map<String,String> addressMap= OriginTest.addressResolution(address);
		String village=addressMap.get("village");
		if(!village.equals("")){
			map=personnelInfoService.getNeighborByAddress(village);
		}
		return map;
	}
	
	/**
	 * 物品
	 */
	@RequestMapping("/asset/list")
	@SystemControllerLog(description="人员档案-物品")
	public Map<String, Object> getAssetList(HttpServletRequest req,String idCard) throws Exception {
		Map<String, Object> map=new HashMap<>();
		Map<String, Object> carMap=personnelInfoService.getCarByIdCard(idCard);
		map.put("carList", carMap);
		return map;
	}
	
	
}
