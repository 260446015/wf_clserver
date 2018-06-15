package com.zkjl.wf_clserver.core.service.impl;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.dto.req.TrackRQ;
import com.zkjl.wf_clserver.core.service.TrackService;
import com.zkjl.wf_clserver.core.util.MongoManager;
import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class TrackServiceImpl implements TrackService {

	@Override
	public Map<String, Object> findStay(String idCard,Date beginDate,Date endDate,String city) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("stay");
		BasicDBObject queryObject = new BasicDBObject().append("id_card", idCard);
		if (StringUtils.isNotBlank(city)) {
			Pattern pattern = Pattern.compile("^.*"+city.trim()+".*$",Pattern.CASE_INSENSITIVE); 
			queryObject.append("local", pattern);
		}
		BasicDBList condList = new BasicDBList();
		if(beginDate!=null && endDate!=null) { 
			condList.add(new BasicDBObject("check_in_time", new BasicDBObject("$gte", beginDate +" 00:00:00").append("$lte", endDate +" 00:00:00")));
			queryObject.put("$and", condList);
		} 
		FindIterable<Document> docIte= conllections.find(queryObject).sort(new BasicDBObject().append("check_in_time", -1));
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
	public Map<String, Object> findInternetBar(String idCard,Date beginDate,Date endDate,String city) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("internet_bar");
		BasicDBObject queryObject = new BasicDBObject().append("id_card", idCard);
		if (StringUtils.isNotBlank(city)) {
			Pattern pattern = Pattern.compile("^.*"+city.trim()+".*$",Pattern.CASE_INSENSITIVE); 
			queryObject.append("local", pattern);
		}
		BasicDBList condList = new BasicDBList();
		if(beginDate!=null && endDate!=null) { 
			condList.add(new BasicDBObject("open_time", new BasicDBObject("$gte", beginDate +" 00:00:00").append("$lte", endDate +" 00:00:00")));
			queryObject.put("$and", condList);
		} 
		FindIterable<Document> docIte= conllections.find(queryObject).sort(new BasicDBObject().append("open_time", -1));
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
	public Map<String, Object> findTakeTrain(String idCard,Date beginDate,Date endDate,String city) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("Train");
		BasicDBObject queryObject = new BasicDBObject().append("id_card", idCard);
		if (StringUtils.isNotBlank(city)) {
			Pattern pattern = Pattern.compile("^.*"+city.trim()+".*$",Pattern.CASE_INSENSITIVE); 
			queryObject.append("from_address", pattern);
		}
		BasicDBList condList = new BasicDBList();
		if(beginDate!=null && endDate!=null) { 
			condList.add(new BasicDBObject("ride_date", new BasicDBObject("$gte", beginDate +" 00:00:00").append("$lte", endDate +" 00:00:00")));
			queryObject.put("$and", condList);
		} 
		FindIterable<Document> docIte= conllections.find(queryObject).sort(new BasicDBObject().append("ride_date", -1));
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
	public Map<String, Object> findTakePlane(String idCard,Date beginDate,Date endDate,String city) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("aircraft");
		BasicDBObject queryObject = new BasicDBObject().append("id_card", idCard);
		if (StringUtils.isNotBlank(city)) {
			Pattern pattern = Pattern.compile("^.*"+city.trim()+".*$",Pattern.CASE_INSENSITIVE); 
			queryObject.append("from_address", pattern);
		}
		BasicDBList condList = new BasicDBList();
		if(beginDate!=null && endDate!=null) { 
			condList.add(new BasicDBObject("departure_time", new BasicDBObject("$gte", beginDate +" 00:00:00").append("$lte", endDate +" 00:00:00")));
			queryObject.put("$and", condList);
		} 
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("id_card", idCard)).sort(new BasicDBObject().append("departure_time", -1));
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
	public Map<String, Object> findEntryExit(String idCard,Date beginDate,Date endDate,String city) {
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("passport");
		BasicDBObject queryObject = new BasicDBObject().append("id_card", idCard);
		if (StringUtils.isNotBlank(city)) {
			Pattern pattern = Pattern.compile("^.*"+city.trim()+".*$",Pattern.CASE_INSENSITIVE); 
			queryObject.append("issuePlace", pattern);
		}
		BasicDBList condList = new BasicDBList();
		if(beginDate!=null && endDate!=null) { 
			condList.add(new BasicDBObject("issueDate", new BasicDBObject("$gte", beginDate +" 00:00:00").append("$lte", endDate +" 00:00:00")));
			queryObject.put("$and", condList);
		} 
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("id_card", idCard)).sort(new BasicDBObject().append("issueDate", -1));
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
	public Map<String, Object> findTrackTimeLine(TrackRQ trackRQ) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if(trackRQ.getTrackType().equals("")||trackRQ.getTrackType().equals("1")){
			Map<String, Object> stayMap=findStay(trackRQ.getIdCard(),trackRQ.getBeginDate(),trackRQ.getEndDate(),trackRQ.getCity());
			dataMap.put("stayList", stayMap.get("list"));
		}else if(trackRQ.getTrackType().equals("2")){
			//查询网吧上网记录
			Map<String, Object> internetBarMap=findInternetBar(trackRQ.getIdCard(),trackRQ.getBeginDate(),trackRQ.getEndDate(),trackRQ.getCity());
			dataMap.put("internetBarList", internetBarMap.get("list"));
		}else if(trackRQ.getTrackType().equals("3")){
			//查询乘坐客车记录		
			dataMap.put("busList", null);
		}else if(trackRQ.getTrackType().equals("4")){
			//查询乘坐火车记录
			Map<String, Object> takeTrainMap=findTakeTrain(trackRQ.getIdCard(),trackRQ.getBeginDate(),trackRQ.getEndDate(),trackRQ.getCity());
			dataMap.put("takeTrainList", takeTrainMap.get("list"));
		}else if(trackRQ.getTrackType().equals("5")){
			//查询乘坐飞机记录
			Map<String, Object> takePlaneMap=findTakePlane(trackRQ.getIdCard(),trackRQ.getBeginDate(),trackRQ.getEndDate(),trackRQ.getCity());
			dataMap.put("takePlaneList", takePlaneMap.get("list"));
		}else if(trackRQ.getTrackType().equals("6")){
			//查询出入境记录
			Map<String, Object> entryExitMap=findEntryExit(trackRQ.getIdCard(),trackRQ.getBeginDate(),trackRQ.getEndDate(),trackRQ.getCity());
			dataMap.put("entryExitList", entryExitMap.get("list"));
		}else if(trackRQ.getTrackType().equals("7")){
			//查询人像轨迹记录
			dataMap.put("portraitList", null);
		}else if(trackRQ.getTrackType().equals("8")){
			//查询628轨迹信息
			dataMap.put("trajectory", null);
		}
		
		return dataMap;
	}

}
