package com.zkjl.wf_clserver.core.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.service.InternetService;
import com.zkjl.wf_clserver.core.util.MongoManager;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InternetServiceImpl implements InternetService {

	@Override
	public Map<String, Object> getBroadband(String mobile) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("broadband");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("mobile", mobile));
		Iterator<Document> it = docIte.iterator();
		List<Object> dataList = new ArrayList<Object>();
		while (it.hasNext()) {
			Document doc = it.next();
			dataList.add(doc);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		dataMap.put("count", dataList.size());
		return dataMap;
	}

	@Override
	public Map<String, Object> getQQList(String mobile) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("qq");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("mobile", mobile));
		Iterator<Document> it = docIte.iterator();
		List<Object> dataList = new ArrayList<Object>();
		while (it.hasNext()) {
			Document doc = it.next();
			dataList.add(doc);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		dataMap.put("count", dataList.size());
		return dataMap;
	}

	@Override
	public Map<String, Object> getWechatList(String mobile) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("Wechat");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("mobile", mobile));
		Iterator<Document> it = docIte.iterator();
		List<Object> dataList = new ArrayList<Object>();
		while (it.hasNext()) {
			Document doc = it.next();
			dataList.add(doc);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		dataMap.put("count", dataList.size());
		return dataMap;
	}

	@Override
	public Map<String, Object> getTwitterList(String mobile) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("Twitter");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("mobile", mobile));
		Iterator<Document> it = docIte.iterator();
		List<Object> dataList = new ArrayList<Object>();
		while (it.hasNext()) {
			Document doc = it.next();
			dataList.add(doc);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		dataMap.put("count", dataList.size());
		return dataMap;
	}

	@Override
	public Map<String, Object> getForumList(String mobile) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("forum");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("mobile", mobile));
		Iterator<Document> it = docIte.iterator();
		List<Object> dataList = new ArrayList<Object>();
		while (it.hasNext()) {
			Document doc = it.next();
			dataList.add(doc);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		dataMap.put("count", dataList.size());
		return dataMap;
	}

}
