package com.zkjl.wf_clserver.core.service.impl;

import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.entity.Log;
import com.zkjl.wf_clserver.core.service.LogService;
import com.zkjl.wf_clserver.core.util.MongoManager;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

	@Override
	public void createLog(Log log) {
		MongoCollection<Document> collection = MongoManager.getMongoDatabase()
				.getCollection("SysLog");
		Document doc = new Document();
		log.preInsert();
		doc.append("id", log.getId());
		doc.append("name", log.getName());
		doc.append("sysUserId", log.getSysUserId());
		doc.append("category", log.getCategory());
		doc.append("description", log.getDescription());
		doc.append("ip", log.getIp());
		doc.append("sysUserId", log.getSysUserId());
		doc.append("create_date", log.getCreateDate());
		doc.append("del_flag", log.getDelFlag());
		collection.insertOne(doc);

	}

}
