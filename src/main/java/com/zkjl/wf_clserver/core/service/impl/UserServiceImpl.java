package com.zkjl.wf_clserver.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.repository.kklc.LoginCountRepository;
import com.zkjl.wf_clserver.core.repository.kklc.SysUserRepository;
import com.zkjl.wf_clserver.core.service.UserService;
import com.zkjl.wf_clserver.core.util.MongoManager;
import com.zkjl.wf_clserver.core.util.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserRepository sysUserRepository;
	@Resource
	private SessionDAO sessionDAO;
	@Resource
	private LoginCountRepository loginCountRepository;
	/** 登陆判断 */
	@Override
	public SysUser login(String username, String password) {
		try {
			SysUser sysUser = sysUserRepository.findByNameAndPassword(username,password);
			return sysUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/** 根据用户姓名或者登录名模糊查询 */
	@Override
	public PageImpl<SysUser> findUser(Integer pageSize,Integer pageNum,String searchStr) {
		List<SysUser> all = sysUserRepository.findAll();
		int totalCount;
		all = all.stream().sorted((a,b) -> b.getCreateDate().compareTo(a.getCreateDate())).collect(Collectors.toList());
		if(!StringUtils.isBlank(searchStr)){
			all = all.stream().filter(sysUser -> sysUser.toString().contains(searchStr)).collect(Collectors.toList());
		}
		totalCount = all.size();
		return (PageImpl<SysUser>) PageUtil.pageBeagin(totalCount,pageNum,pageSize,all);
	}

	/** 获取分页查询的总数 */
	@Override
	public Long getTotalUser(String keyword) {
		BasicDBObject criteria =new BasicDBObject();
		if(keyword!=null){
			Pattern pattern = Pattern.compile("^.*" + keyword+ ".*$", Pattern.CASE_INSENSITIVE); 
			criteria.append("name", pattern);
		}
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("SysUser");
		return conllections.count(criteria);
	}
	
	/** 获取该用户是否存在 */
	@Override
	public boolean ifExist(String username) {
		return null != sysUserRepository.findByName(username)?true:false;
	}
	

	/** 更新用户信息 */
	@Override
	public boolean addUserOrUpdate(SysUser user) {
		try {
			user.setCreateDate(new Date());
			sysUserRepository.save(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/** 根据用户id删除用户 */
	@Override
	public void deleteUser(String id) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("SysUser");
		BasicDBObject query = new BasicDBObject();
		query.put("id", id);
		//删除id为1的文档
		conllections.deleteOne(query);

	}

	@Override
	public JSONObject listActiveSession() {
		JSONObject jsonObject = new JSONObject();
		Collection<Session> activeSessions = sessionDAO.getActiveSessions();
		jsonObject.put("activeCount",activeSessions.size());
		jsonObject.put("allCount",loginCountRepository.findAll().size());
		return jsonObject;
	}
}
