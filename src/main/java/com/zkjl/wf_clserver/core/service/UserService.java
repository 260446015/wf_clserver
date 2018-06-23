package com.zkjl.wf_clserver.core.service;

import com.zkjl.wf_clserver.core.dto.LoginDTO;
import com.zkjl.wf_clserver.core.entity.Admins;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.entity.User;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.Map;

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

}
