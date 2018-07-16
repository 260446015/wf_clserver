package com.zkjl.wf_clserver.core.dto.req;

import lombok.Data;

@Data
public class AnalysisRQ extends AbstractPageRQ{

	private String jobid;

	/**
	 * 平台
	 */
	private String platform;
	/**
	 * 类型
	 */
	private String dataType;
}
