package com.zkjl.wf_clserver.core.service;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.entity.SysUser;
import org.springframework.data.domain.PageImpl;

public interface UserService {

	/**
	 * 登陆
	 */
	SysUser login(String username, String password);

	/**
	 * 查找用户
	 */
	PageImpl<SysUser> findUser(Integer pageSize,Integer pageNum,String searchStr);

	/**
	 * 查询用户总数
	 */
	public Long getTotalUser(String keyword);
	
	/** 获取该用户是否存在 */
	public boolean ifExist(String username);

	/**
	 * 添加用户
	 */
	boolean addUserOrUpdate(SysUser user);

	/**
	 * 删除用户
	 */
	public void deleteUser(String id);

    JSONObject listActiveSession();
}
