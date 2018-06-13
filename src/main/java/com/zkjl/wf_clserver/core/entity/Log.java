package com.zkjl.wf_clserver.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkjl.wf_clserver.core.util.UuidUtils;

import java.util.Date;

/** 用户实体类 */
public class Log {
	private String id; // 主键
	private String sysUserId; // 操作人
	private String category; // 操作类型
	private String description; // 操作描述
	private String ip; // 操作ip
	private String name; // 操作人姓名
	private String type; //日志类型(info:入库,error:错误)
	private Date createDate;
	private String delFlag;
	private String requestUri;//请求的Uri
	
	public Log() {
		this.delFlag = "0";
	}
	
	public Log(String id) {
		super();
		this.delFlag = "0";
	}
	 
	public void preInsert()
	  {
	     setId(UuidUtils.creatUUID());
	    if (this.createDate == null)
	      this.createDate = new Date();
	  }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sysUserId
	 */
	public String getSysUserId() {
		return sysUserId;
	}

	/**
	 * @param sysUserId the sysUserId to set
	 */
	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the createDate
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the delFlag
	 */
	public String getDelFlag() {
		return delFlag;
	}

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * @return the requestUri
	 */
	public String getRequestUri() {
		return requestUri;
	}

	/**
	 * @param requestUri the requestUri to set
	 */
	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}
