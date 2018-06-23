package com.zkjl.wf_clserver.core.util;


import com.zkjl.wf_clserver.core.entity.ResultData;

/**
 * 
 * Result工厂
 * @author Jason.zhang
 * @since 2017/7/10
 *
 */
public class ResultFactory {


	/**
	 * 创建成功响应数据
	 * @param params
	 * @return
	 */
	public static ResultData createSuccess(Object ... params){
		ResultData resultData =new ResultData();
		resultData.setSuccess(true);
		if(params.length==1){
			resultData.setMsg(params[0]==null?"":params[0].toString());	
		}else if(params.length==2){
			resultData.setMsg(params[0]==null?"":params[0].toString());
			resultData.setData(params[1]);
		}
		return resultData;
	}
	
	/**
	 * 创建失败响应数据
	 * @param params
	 * @return
	 */
	public static ResultData createFail(Object ... params){
		ResultData resultData =new ResultData();
		resultData.setSuccess(false);
		if(params.length==1){
			resultData.setMsg(params[0]==null?"":params[0].toString());	
		}else if(params.length==2){
			resultData.setMsg(params[0]==null?"":params[0].toString());
			resultData.setData(params[1]);
		}
		return resultData;
	}
	
	
}
