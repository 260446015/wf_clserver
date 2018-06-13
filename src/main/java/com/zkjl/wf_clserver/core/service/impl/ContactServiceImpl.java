package com.zkjl.wf_clserver.core.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.service.ContactService;
import com.zkjl.wf_clserver.core.util.MongoManager;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContactServiceImpl implements ContactService {

	@Override
	public Map<String, Object> getListByIdCard(String idCard) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("contact_way");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("id_card", idCard)).sort(new BasicDBObject().append("create_date", -1));
		Iterator<Document> it = docIte.iterator();
		List<Object> dataList = new ArrayList<Object>();
		while (it.hasNext()) {
			Document doc = it.next();
			dataList.add(doc);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("list", dataList);
		return dataMap;
	}

}
