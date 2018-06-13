package com.zkjl.wf_clserver.core.service;

import java.util.Map;

public interface InternetService {
	
	/**
	 * 查找宽带信息
	 * @param mobile 手机号
	 * @return
	 */
	public Map<String, Object> getBroadband(String mobile);
	
	/**
	 * 查找QQ信息
	 * @param mobile 手机号
	 * @return
	 */
	public Map<String, Object> getQQList(String mobile);
	
	/**
	 * 查找微信信息
	 * @param mobile 手机号
	 * @return
	 */
	public Map<String, Object> getWechatList(String mobile);
	
	/**
	 * 查找微博信息
	 * @param mobile 手机号
	 * @return
	 */
	public Map<String, Object> getTwitterList(String mobile);
	
	/**
	 * 查找论坛信息
	 * @param mobile 手机号
	 * @return
	 */
	public Map<String, Object> getForumList(String mobile);
}
