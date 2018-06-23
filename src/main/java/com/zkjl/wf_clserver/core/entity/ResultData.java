package com.zkjl.wf_clserver.core.entity;

/**
 * 
 * http响应结构实体
 * @author Jason.zhang
 * @mobile 18282600855
 * @since 2017/7/10
 *
 */
public class ResultData {

	private boolean success;
	private String msg;
	private Object data;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
