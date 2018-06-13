package com.zkjl.wf_clserver.core.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.service.FocusService;
import com.zkjl.wf_clserver.core.util.MongoManager;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FocusServiceImpl implements FocusService {

	@Override
	public Map<String, Object> getCrimeInfor(String idCard) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("crime_infor");
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
	public Map<String, Object> getFugitiveInfor(String idCard) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("fugitive_infor");
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
	public Map<String, Object> getDrugAddictsInfo(String idCard) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("fugitive_infor");
		Document doc= conllections.find(new BasicDBObject().append("id_card", idCard)).first();
		
		MongoCollection<Document> conllectionTube = MongoManager.getMongoDatabase().getCollection("tube_record");
		Document documentTube= conllectionTube.find(new BasicDBObject().append("id_card", idCard)).first();
		
		MongoCollection<Document> conllectioncr = MongoManager.getMongoDatabase().getCollection("check_register");
		Document documentcr= conllectioncr.find(new BasicDBObject().append("id_card", idCard)).first();
		
		MongoCollection<Document> conllectiondr = MongoManager.getMongoDatabase().getCollection("disposal_record");
		Document documentdr= conllectiondr.find(new BasicDBObject().append("id_card", idCard)).first();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("doc", doc);
		dataMap.put("docTube", documentTube);
		dataMap.put("doccr", documentcr);
		dataMap.put("docdr", documentdr);
		return dataMap;
	}

	@Override
	public Map<String, Object> getClosedLoop(String idCard) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("closed_loop");
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
	public Map<String, Object> getStabilityPoint(String idCard) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("stability_point");
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
