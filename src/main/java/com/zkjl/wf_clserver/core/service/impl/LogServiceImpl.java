package com.zkjl.wf_clserver.core.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.entity.Log;
import com.zkjl.wf_clserver.core.service.LogService;
import com.zkjl.wf_clserver.core.util.MongoManager;
import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {
	@Resource(name = "primaryMongoTemplate")
	private MongoTemplate primaryMongoTemplate;

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
	@Override
	public PageImpl<Log> findPage(Integer pageSize, Integer pageNum, String username, Date beginDate, Date endDate){
		MongoCollection<Document> conllections = primaryMongoTemplate.getCollection("log");
		BasicDBObject basicDBObject = new BasicDBObject();
		if (StringUtils.isNotBlank(username)) {
			basicDBObject.append("name", username);
		} else if (beginDate != null && endDate != null) {
			basicDBObject.append("createDate", new BasicDBObject("$gte", beginDate ).append("$lte", endDate));
		}
		FindIterable<Document> docIte = conllections.find(basicDBObject);
		Iterator<Document> it = docIte.iterator();
		List<Log> all = new ArrayList<Log>();
		while (it.hasNext()) {
			Document doc = it.next();
			Log log = new Log();
			log.setId(doc.getObjectId("_id").toString());
			log.setName(doc.getString("name"));
			log.setIp(doc.getString("ip"));
			log.setDescription(doc.getString("description"));
			log.setCreateDate(doc.getDate("createDate"));
			all.add(log);
		}
		int totalCont = 0;
		all = all.stream().sorted((a, b) -> b.getCreateDate().compareTo(a.getCreateDate())).collect(Collectors.toList());
		totalCont = all.size();
		all = all.stream().skip(pageNum * pageSize).limit(pageSize).collect(Collectors.toList());
		PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
		PageImpl<Log> logPage = new PageImpl<>(all, pageRequest, totalCont);
		return logPage;
	}
	@Override
	public void deleteLog(String id){
		MongoCollection<Document> conllections = primaryMongoTemplate.getCollection("log");
		BasicDBObject query = new BasicDBObject();
		ObjectId objid=new ObjectId(id);
		query.put("_id", objid);
		//删除id为1的文档
		conllections.deleteOne(query);
	}

}
