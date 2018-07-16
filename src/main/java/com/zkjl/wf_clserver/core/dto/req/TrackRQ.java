package com.zkjl.wf_clserver.core.dto.req;

import lombok.Data;

@Data
public class TrackRQ {

	private String jobid;

	/**
	 * 轨迹类型
	 */
	private String trackType;
	/**
	 * 开始时间
	 */
	private String beginDate;
	/**
	 * 结束时间
	 */
	private String endDate;
	



	
}
