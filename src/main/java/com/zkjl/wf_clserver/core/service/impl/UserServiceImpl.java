package com.zkjl.wf_clserver.core.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.dto.LoginDTO;
import com.zkjl.wf_clserver.core.entity.Admins;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.entity.User;
import com.zkjl.wf_clserver.core.repository.AdminsRepository;
import com.zkjl.wf_clserver.core.repository.SysUserRepository;
import com.zkjl.wf_clserver.core.service.UserService;
import com.zkjl.wf_clserver.core.util.MongoManager;
import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserRepository sysUserRepository;
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
		if(!StringUtils.isBlank(searchStr)){
			all = all.stream().filter(sysUser -> sysUser.toString().contains(searchStr)).collect(Collectors.toList());
		}
		int count = all.size();
		long totalpage =count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
		totalpage=totalpage==0?1:totalpage;
		PageImpl<SysUser> sysUserPage = new PageImpl<>(all);
		return sysUserPage;
	}

	/** 更新用户信息 */
	@Override
	public int updateUser(User user) {
		int result=0;
		MongoCollection<Document> collection = MongoManager.getMongoDatabase()
				.getCollection("stationhistorys");
		BasicDBObject condition = new BasicDBObject();
		condition.put("id", user.getId());
		BasicDBObject updateValue = new BasicDBObject();
		updateValue.put("username",user.getUserName());
		updateValue.put("password", user.getPassword());
		updateValue.put("name", user.getName());
		updateValue.put("photo", user.getPhone());
		updateValue.put("police_number", user.getPoliceNumber());
		updateValue.put("job", user.getJob());
		updateValue.put("department", user.getDepartment());
		updateValue.put("create_date", user.getCreateDate());
		updateValue.put("update_date", user.getUpdateDate());
		updateValue.put("del_flag", user.getDelFlag());
		BasicDBObject update = new BasicDBObject("$set", updateValue);
		try {
			collection.updateOne(condition, update);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		result=1;
		return result;
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
		BasicDBObject criteria =new BasicDBObject();
		if(username!=null){
			Pattern pattern = Pattern.compile("^.*" + username+ ".*$", Pattern.CASE_INSENSITIVE); 
			criteria.append("username", pattern);
		}
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("SysUser");
		if(conllections.count(criteria)==1){
			return true;
		}else{
			return false;
		}
		 
	}
	

	/** 更新用户信息 */
	@Override
	public void addUser(User user) {
		MongoCollection<Document> collection = MongoManager.getMongoDatabase()
				.getCollection("SysUser");
		Document doc = new Document();
		user.preInsert();
		doc.append("id", user.getId());
		doc.append("username", user.getUserName());
		doc.append("password", user.getPassword());
		doc.append("name", user.getName());
		doc.append("photo", user.getPhone());
		doc.append("police_number", user.getPoliceNumber());
		doc.append("job", user.getJob());
		doc.append("department", user.getDepartment());
		doc.append("create_date", user.getCreateDate());
		doc.append("update_date", user.getUpdateDate());
		doc.append("del_flag", user.getDelFlag());
		collection.insertOne(doc);
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


}
