package com.zkjl.wf_clserver.core.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.service.SocialService;
import com.zkjl.wf_clserver.core.util.MongoManager;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SocialServiceImpl implements SocialService {

	@Override
	public Map<String, Object> getBankInfo(String idCard) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("bank_info");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("id_card", idCard));
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
	public Map<String, Object> getWorkers(String idCard) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("Workers");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("id_card", idCard));
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
	public Map<String, Object> getMedicalInsurance(String idCard) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("medical_insurance");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("id_card", idCard));
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
	public Map<String, Object> getFund(String idCard) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("fund");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("id_card", idCard));
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
