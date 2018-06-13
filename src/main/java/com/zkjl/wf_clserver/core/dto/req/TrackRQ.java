package com.zkjl.wf_clserver.core.dto.req;

import java.util.Date;

public class TrackRQ {
	/**
	 * 证件号码
	 */
	private String idCard;
	/**
	 * 查询类型
	 */
	private String searchType;
	/**
	 * 轨迹类型
	 */
	private String trackType;
	/**
	 * 开始时间
	 */
	private Date beginDate;
	/**
	 * 结束时间
	 */
	private Date endDate;
	
	/**
	 * 是否查询本市记录
	 */
	private String city;
	
	/**
	 * 获取证件号码
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * 设置证件号码
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * 获取查询类型
	 * @return the searchType
	 */
	public String getSearchType() {
		return searchType;
	}
	
	/**
	 * 设置查询类型
	 * @param searchType the searchType to set
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	/**
	 * 获取轨迹类型
	 * @return the trackType
	 */
	public String getTrackType() {
		return trackType;
	}
	
	/**
	 * 设置轨迹类型
	 * @param trackType the trackType to set
	 */
	public void setTrackType(String trackType) {
		this.trackType = trackType;
	}
	
	/**
	 * 获取开始时间
	 * @return the beginDate
	 */
	public Date getBeginDate() {
		return beginDate;
	}
	
	/**
	 * 设置开始时间
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	/**
	 * 获取结束时间
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * 设置结束时间
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 获取城市
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置城市
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
}
