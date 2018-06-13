package com.zkjl.wf_clserver.core.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.entity.User;
import com.zkjl.wf_clserver.core.service.UserService;
import com.zkjl.wf_clserver.core.util.JdbcUtil;
import com.zkjl.wf_clserver.core.util.MongoManager;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service("userService")
public class UserServiceImpl implements UserService {

	/** 登陆判断 */
	@Override
	public Document login(String username, String password) {
		try {
			MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("users");
			Document doc = conllections.find(new BasicDBObject().append("username", username).append("password", password)).first();
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/** 根据用户姓名或者登录名模糊查询 */
	@Override
	public Map<String, Object> findUser(String name, int page,int pageSize) {
		int pagestart =(page-1)*pageSize;
		long count = getTotalUser(name);
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("stationhistorys");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("name", name)).sort(new BasicDBObject().append("create_date", -1)).skip(pagestart).limit(pageSize);
		Iterator<Document> it = docIte.iterator();
		List<Object> dataList = new ArrayList<Object>();
		while (it.hasNext()) {
			Document doc = it.next();
			dataList.add(doc);
		}
		long totalpage =count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
		totalpage=totalpage==0?1:totalpage;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("totalcount", count);
		dataMap.put("totalpage", totalpage);
		dataMap.put("page", page);
		dataMap.put("pageSize", pageSize);
		dataMap.put("list", dataList);
		
		return dataMap;
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
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("sys_user");
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
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("sys_user");
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
				.getCollection("sys_user");
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
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("sys_user");
		BasicDBObject query = new BasicDBObject();
		query.put("id", id);
		//删除id为1的文档
		conllections.deleteOne(query);
	
	}

	/** 首页展示的每个标签对应的节点数量 */
	@Override
	public Map<String, String> findLabels() {
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection();

		HashMap<String, String> hashMap = new HashMap<String, String>();
		List<Map<String, Object>> result = null;
		try {
			// 查询结果集
			result = jdbcUtil
					.findList("match (n) with 'Count' as labels, count(n) as count, labels(n) as label where not 'User' in label RETURN labels,count union all  MATCH (n) with labels(n)[0] as labels, count(n) as count where 'User' <> labels RETURN labels,count order by count desc");
			for (Map<String, Object> map : result) {
				hashMap.put(map.get("labels").toString(), map.get("count").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != jdbcUtil) {
				jdbcUtil.close();
			}
		}
		return hashMap;
	}

}
