package com.zkjl.wf_clserver.core.service;

import java.util.Map;

public interface FocusService {
	/**
	 * 查找违法犯罪信息
	 * @param idCard 身份证号
	 * @returns
	 */
	public Map<String, Object> getCrimeInfor(String idCard); 
	
	/**
	 * 查找在逃人员信息
	 * @param idCard 身份证号
	 * @returns
	 */
	public Map<String, Object> getFugitiveInfor(String idCard); 
	
	/**
	 * 查找涉毒信息
	 * @param idCard 身份证号
	 * @returns
	 */
	public Map<String, Object> getDrugAddictsInfo(String idCard); 
	
	/**
	 * 查找闭环系统信息
	 * @param idCard 身份证号
	 * @returns
	 */
	public Map<String, Object> getClosedLoop(String idCard); 
	
	/**
	 * 查找维稳重点人信息
	 * @param idCard 身份证号
	 * @returns
	 */
	public Map<String, Object> getStabilityPoint(String idCard); 
}
