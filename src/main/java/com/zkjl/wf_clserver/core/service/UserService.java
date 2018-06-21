package com.zkjl.wf_clserver.core.service;

import com.zkjl.wf_clserver.core.entity.Admins;
import com.zkjl.wf_clserver.core.entity.User;

import java.util.Map;

public interface UserService {

	/**
	 * 登陆
	 */
	Admins login(String username, String password);

	/**
	 * 查找用户
	 */
	public Map<String, Object> findUser(String username, int page, int pageSize);

	/**
	 * 查询用户总数
	 */
	public Long getTotalUser(String keyword);
	
	/** 获取该用户是否存在 */
	public boolean ifExist(String username);

	/**
	 * 修改密码
	 */
	public int updateUser(User user);

	/**
	 * 添加用户
	 */
	public void addUser(User user);

	/**
	 * 删除用户
	 */
	public void deleteUser(String id);

}
