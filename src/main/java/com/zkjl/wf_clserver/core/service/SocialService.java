package com.zkjl.wf_clserver.core.service;

import java.util.Map;

public interface SocialService {
	/**
	 * 查找银行信息
	 * @param idCard 身份证号
	 * @returns
	 */
	public Map<String, Object> getBankInfo(String idCard); 
	
	/**
	 * 查找职工
	 * @param idCard 身份证号
	 * @returns
	 */
	public Map<String, Object> getWorkers(String idCard); 
	
	/**
	 * 查找医保
	 * @param idCard 身份证号
	 * @returns
	 */
	public Map<String, Object> getMedicalInsurance(String idCard); 
	
	/**
	 * 查找公积金
	 * @param idCard 身份证号
	 * @returns
	 */
	public Map<String, Object> getFund(String idCard); 

}
