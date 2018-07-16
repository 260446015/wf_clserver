package com.zkjl.wf_clserver.core.service;


import com.zkjl.wf_clserver.core.dto.req.TrackRQ;

import java.util.Date;
import java.util.Map;

public interface TrackService {

	/**
	 * 查找住宿记录
	 * @param idCard 身份证号
	 * @return
	 */
	public Map<String, Object> findStay(String idCard, Date beginDate, Date endDate, String city);

	/**
	 * 查找网吧上网记录
	 * @param idCard 身份证号
	 * @return
	 */
	public Map<String, Object> findInternetBar(String idCard, Date beginDate, Date endDate, String city);

	/**
	 * 查找火车乘坐记录
	 * @param idCard 身份证号
	 * @return
	 */
	public Map<String, Object> findTakeTrain(String idCard, Date beginDate, Date endDate, String city);

	/**
	 * 查找飞机乘坐记录
	 * @param idCard 身份证号
	 * @return
	 */
	public Map<String, Object> findTakePlane(String idCard, Date beginDate, Date endDate, String city);

	/**
	 * 查找出入境记录
	 * @param idCard 身份证号
	 * @return
	 */
	public Map<String, Object> findEntryExit(String idCard, Date beginDate, Date endDate, String city);

}
