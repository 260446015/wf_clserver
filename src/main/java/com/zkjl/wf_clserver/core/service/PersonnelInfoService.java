package com.zkjl.wf_clserver.core.service;

import org.elasticsearch.index.query.BoolQueryBuilder;

import java.util.Map;


public interface PersonnelInfoService {
	/**
	 * 根据人员姓名查询档案
	 * @param name
	 * @return
	 */
	public Map<String, Object> serchByName(String name);
	/**
	 * 根据人员身份证号查询档案
	 * @param idCard
	 * @return
	 */
	public Map<String, Object> serchByIdCard(String idCard);
	/**
	 * 根据人员曾用名查询档案
	 * @param usedName
	 * @return
	 */
	public Map<String, Object> serchByUsedName(String usedName);
	/**
	 * 匹配查询档案
	 * @param bq
	 * @return
	 */
	public Map<String, Object> getResult(BoolQueryBuilder bq);
	/**
	 * 根据查询关键字检索
	 * @param keyword
	 * @return
	 */
	public Map<String, Object> search(String keyword);
	
	/**
	 * 根据地址获取可能邻居关系列表
	 * @param address
	 * @return
	 */
	public Map<String, Object> getNeighborByAddress(String address);
	
	/**
	 * 根据身份证查询驾驶证信息
	 * @param idCard
	 * @return
	 */
	public Map<String, Object> getDriverByIdCard(String idCard);
	
	/**
	 * 根据身份证查询护照信息
	 * @param idCard
	 * @return
	 */
	public Map<String, Object> getPassportByIdCard(String idCard);
	
	/**
	 * 根据身份证查询工作履历
	 * @param idCard
	 * @return
	 */
	public Map<String, Object> getWorkByIdCard(String idCard);
	
	/**
	 * 根据身份证查询车辆信息
	 * @param idCard
	 * @return
	 */
	public Map<String, Object> getCarByIdCard(String idCard);
}
