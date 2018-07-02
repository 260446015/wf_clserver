package com.zkjl.wf_clserver.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.service.PersonnelInfoService;
import com.zkjl.wf_clserver.core.util.EsUtil;
import com.zkjl.wf_clserver.core.util.MongoManager;
import org.bson.Document;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonnelInfoServiceImpl implements PersonnelInfoService {
	
	@Override
	public Map<String, Object> search(String keyword){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = serchByName(keyword);
			List<JSONObject> list = (List<JSONObject>) map.get("list");
			if (null !=list && list.size()>0) {
				return map;
			}else{
				map = serchByIdCard(keyword);
				List<JSONObject> list1 = (List<JSONObject>) map.get("list");
				if (null !=list1 && list1.size()>0) {
					return map;
				}else{
					map = serchByUsedName(keyword);
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public Map<String, Object> serchByName(String name) {

		Client client = EsUtil.getTransportClient();
		SearchRequestBuilder nearbydatasBuilder=client.prepareSearch("lbs").setTypes("PersonnelInfo");
		BoolQueryBuilder bq = new BoolQueryBuilder();
		Set<String> set = new HashSet<>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<JSONObject> list = new ArrayList<JSONObject>();
		bq.must(QueryBuilders.termQuery("name", name));
		SearchRequestBuilder requestBuilder = nearbydatasBuilder.setQuery(bq);
		SearchResponse actionGet = requestBuilder.execute().actionGet();
		SearchHits hits = actionGet.getHits();
		if (null !=hits ) {
			for (SearchHit hit : hits) {
				Map<String, Object> d = hit.getSource();
					if (null != d && d.size() > 0 ) {
						d.put("id", hit.getId());
						if (null != d.get("id_card")) {
							set.add(d.get("id_card").toString());
						}
					}
			}
		}
		if (null != set) {
			if (set.size()==1) {
				for (String string : set) {
					bq.must(QueryBuilders.termsQuery("id_card", string));
					Map<String, Object> result = getResult(bq);
					return result;
				}
			}else if (set.size() > 1) {
				for (String string : set) {
					BoolQueryBuilder bq1 = new BoolQueryBuilder();
					bq1.must(QueryBuilders.termQuery("id_card", string));
					SearchRequestBuilder res = nearbydatasBuilder.setQuery(bq1).setFrom(0).setSize(1);
					SearchResponse actionGet1 = res.execute().actionGet();
					SearchHits hits1 = actionGet1.getHits();
					if (null != hits1 ) {
						for (SearchHit hit : hits1) {
							Map<String, Object> d = hit.getSource();
							if (null != d && d.size() > 0 ) {
								JSONObject jsonObject = new JSONObject();
								d.put("id", hit.getId());
								jsonObject.put("id", d.get("id"));
								jsonObject.put("idCard", d.get("id_card"));
								jsonObject.put("avatar", d.get("avatar"));
								jsonObject.put("usedName", d.get("used_name"));
								jsonObject.put("name", d.get("name"));
								jsonObject.put("phone", d.get("phone"));
								jsonObject.put("sex", d.get("sex"));
								jsonObject.put("nation", d.get("nation"));
								jsonObject.put("education", d.get("education"));
								jsonObject.put("nativePlace", d.get("native_place"));
								jsonObject.put("birthDate", d.get("birth_date"));
								jsonObject.put("politicalOutlook", d.get("political_outlook"));
								jsonObject.put("achievement", d.get("achievement"));
								jsonObject.put("faith", d.get("faith"));
								jsonObject.put("initialAddress", d.get("initial_address"));
								jsonObject.put("maritalStatus", d.get("marital_status"));
								jsonObject.put("workplace", d.get("workplace"));
								jsonObject.put("tag", d.get("tag"));
								jsonObject.put("localPolice", d.get("local_police"));
								list.add(jsonObject);
							}
						}
					}
				}
				map.put("countS", set.size());
				map.put("list", list);
				return map;
			}else{
				map.put("countS", 0);
			}
		}
	
		return map;
	}

	@Override
	public Map<String, Object> serchByIdCard(String idCard){
		Map<String, Object> map = new HashMap<String, Object>();
		List<JSONObject> list = new ArrayList<JSONObject>();
		Client client = EsUtil.getTransportClient();
	    SearchRequestBuilder nearbydatasBuilder=client.prepareSearch("lbs").setTypes("PersonnelInfo");
		BoolQueryBuilder bq = new BoolQueryBuilder();
		bq.must(QueryBuilders.termQuery("id_card", idCard));
		SearchRequestBuilder res = nearbydatasBuilder.setQuery(bq).setFrom(0).setSize(30);
		SearchResponse actionGet = res.execute().actionGet();
		SearchHits hits = actionGet.getHits();
		if (null != hits ) {
			for (SearchHit hit : hits) {
				Map<String, Object> d = hit.getSource();
				if (null != d && d.size() > 0 ) {
					JSONObject jsonObject = new JSONObject();
					d.put("id", hit.getId());
					jsonObject.put("id", d.get("id"));
					jsonObject.put("idCard", d.get("id_card"));
					jsonObject.put("avatar", d.get("avatar"));
					jsonObject.put("usedName", d.get("used_name"));
					jsonObject.put("name", d.get("name"));
					jsonObject.put("phone", d.get("phone"));
					jsonObject.put("sex", d.get("sex"));
					jsonObject.put("nation", d.get("nation"));
					jsonObject.put("education", d.get("education"));
					jsonObject.put("nativePlace", d.get("native_place"));
					jsonObject.put("birthDate", d.get("birth_date"));
					jsonObject.put("politicalOutlook", d.get("political_outlook"));
					jsonObject.put("achievement", d.get("achievement"));
					jsonObject.put("faith", d.get("faith"));
					jsonObject.put("initialAddress", d.get("initial_address"));
					jsonObject.put("maritalStatus", d.get("marital_status"));
					jsonObject.put("workplace", d.get("workplace"));
					jsonObject.put("tag", d.get("tag"));
					jsonObject.put("localPolice", d.get("local_police"));
					list.add(jsonObject);
				}
			}
			map.put("countS", 1);
			map.put("list", list);
			return map;
		}else{
			map.put("countS", 0);
		}
		return map;
	}

	@Override
	public Map<String, Object> serchByUsedName(String usedName) {
		Client client = EsUtil.getTransportClient();
		SearchRequestBuilder nearbydatasBuilder=client.prepareSearch("lbs").setTypes("PersonnelInfo");
		BoolQueryBuilder bq = new BoolQueryBuilder();
		Set<String> set = new HashSet<>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<JSONObject> list = new ArrayList<JSONObject>();
		bq.must(QueryBuilders.termQuery("used_name", usedName));
		SearchRequestBuilder requestBuilder = nearbydatasBuilder.setQuery(bq);
		SearchResponse actionGet = requestBuilder.execute().actionGet();
		SearchHits hits = actionGet.getHits();
		if (null !=hits ) {
			for (SearchHit hit : hits) {
				Map<String, Object> d = hit.getSource();
					if (null != d && d.size() > 0 ) {
						d.put("id", hit.getId());
						if (null != d.get("id_card")) {
							set.add(d.get("id_card").toString());
						}
					}
			}
		}
		if (null != set) {
			if (set.size()==1) {
				for (String string : set) {
					bq.must(QueryBuilders.termsQuery("id_card", string));
					Map<String, Object> result = getResult(bq);
					return result;
				}
			}else if (set.size() > 1) {
				for (String string : set) {
					BoolQueryBuilder bq1 = new BoolQueryBuilder();
					bq1.must(QueryBuilders.termQuery("id_card", string));
					SearchRequestBuilder res = nearbydatasBuilder.setQuery(bq1).setFrom(0).setSize(1);
					SearchResponse actionGet1 = res.execute().actionGet();
					SearchHits hits1 = actionGet1.getHits();
					if (null != hits1 ) {
						for (SearchHit hit : hits1) {
							Map<String, Object> d = hit.getSource();
							if (null != d && d.size() > 0 ) {
								JSONObject jsonObject = new JSONObject();
								d.put("id", hit.getId());
								jsonObject.put("id", d.get("id"));
								jsonObject.put("idCard", d.get("id_card"));
								jsonObject.put("avatar", d.get("avatar"));
								jsonObject.put("usedName", d.get("used_name"));
								jsonObject.put("name", d.get("name"));
								jsonObject.put("phone", d.get("phone"));
								jsonObject.put("sex", d.get("sex"));
								jsonObject.put("nation", d.get("nation"));
								jsonObject.put("education", d.get("education"));
								jsonObject.put("nativePlace", d.get("native_place"));
								jsonObject.put("birthDate", d.get("birth_date"));
								jsonObject.put("politicalOutlook", d.get("political_outlook"));
								jsonObject.put("achievement", d.get("achievement"));
								jsonObject.put("faith", d.get("faith"));
								jsonObject.put("initialAddress", d.get("initial_address"));
								jsonObject.put("maritalStatus", d.get("marital_status"));
								jsonObject.put("workplace", d.get("workplace"));
								jsonObject.put("tag", d.get("tag"));
								jsonObject.put("localPolice", d.get("local_police"));
								list.add(jsonObject);
							}
						}
					}
				}
				map.put("countS", set.size());
				map.put("list", list);
				return map;
			}else{
				map.put("countS", 0);
			}
		}
	
		return map;
	}
	
	public Map<String, Object> getResult(BoolQueryBuilder bq){
		Map<String, Object> map = new HashMap<String, Object>();
		List<JSONObject> list = new ArrayList<JSONObject>();
		Client client = EsUtil.getTransportClient();
		try {
			SearchRequestBuilder nearbydatasBuilder=client.prepareSearch("lbs").setTypes("PersonnelInfo");
			SearchRequestBuilder res = nearbydatasBuilder.setQuery(bq).setFrom(0).setSize(30);
			SearchResponse actionGet = res.execute().actionGet();
			SearchHits hits = actionGet.getHits();
			if (null != hits ) {
				for (SearchHit hit : hits) {
					Map<String, Object> d = hit.getSource();
					if (null != d && d.size() > 0 ) {
						JSONObject jsonObject = new JSONObject();
						d.put("id", hit.getId());
						jsonObject.put("id", d.get("id"));
						jsonObject.put("idCard", d.get("id_card"));
						jsonObject.put("avatar", d.get("avatar"));
						jsonObject.put("usedName", d.get("used_name"));
						jsonObject.put("name", d.get("name"));
						jsonObject.put("phone", d.get("phone"));
						jsonObject.put("sex", d.get("sex"));
						jsonObject.put("nation", d.get("nation"));
						jsonObject.put("education", d.get("education"));
						jsonObject.put("nativePlace", d.get("native_place"));
						jsonObject.put("birthDate", d.get("birth_date"));
						jsonObject.put("politicalOutlook", d.get("political_outlook"));
						jsonObject.put("achievement", d.get("achievement"));
						jsonObject.put("faith", d.get("faith"));
						jsonObject.put("initialAddress", d.get("initial_address"));
						jsonObject.put("maritalStatus", d.get("marital_status"));
						jsonObject.put("workplace", d.get("workplace"));
						jsonObject.put("tag", d.get("tag"));
						jsonObject.put("localPolice", d.get("local_police"));
						list.add(jsonObject);
					}
				}
				map.put("countS", 1);
				map.put("list", list);
				return map;
			}else{
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public Map<String, Object> getDriverByIdCard(String idCard){
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("driver_info");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("id_card", idCard)).sort(new BasicDBObject().append("begin_date", -1));
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
	
	@Override
	public Map<String, Object> getPassportByIdCard(String idCard){
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("Passport");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("id_card", idCard)).sort(new BasicDBObject().append("issueDate", -1));
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
	@Override
	public Map<String, Object> getWorkByIdCard(String idCard){
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("WorkResume");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("id_card", idCard)).sort(new BasicDBObject().append("work_time", -1));
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
	@Override
	public Map<String, Object> getNeighborByAddress(String address){
		Client client = EsUtil.getTransportClient();
		SearchRequestBuilder nearbydatasBuilder=client.prepareSearch("lbs").setTypes("PersonnelInfo");
		BoolQueryBuilder bq = new BoolQueryBuilder();
		Set<String> set = new HashSet<>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<JSONObject> list = new ArrayList<JSONObject>();
		bq.must(QueryBuilders.termQuery("residence_address", address));
		SearchRequestBuilder requestBuilder = nearbydatasBuilder.setQuery(bq);
		SearchResponse actionGet = requestBuilder.execute().actionGet();
		SearchHits hits = actionGet.getHits();
		if (null !=hits ) {
			for (SearchHit hit : hits) {
				Map<String, Object> d = hit.getSource();
					if (null != d && d.size() > 0 ) {
						d.put("id", hit.getId());
						if (null != d.get("id_card")) {
							set.add(d.get("id_card").toString());
						}
					}
			}
		}
		if (null != set) {
			if (set.size()==1) {
				for (String string : set) {
					bq.must(QueryBuilders.termsQuery("id_card", string));
					Map<String, Object> result = getResult(bq);
					return result;
				}
			}else if (set.size() > 1) {
				for (String string : set) {
					BoolQueryBuilder bq1 = new BoolQueryBuilder();
					bq1.must(QueryBuilders.termQuery("id_card", string));
					SearchRequestBuilder res = nearbydatasBuilder.setQuery(bq1).setFrom(0).setSize(1);
					SearchResponse actionGet1 = res.execute().actionGet();
					SearchHits hits1 = actionGet1.getHits();
					if (null != hits1 ) {
						for (SearchHit hit : hits1) {
							Map<String, Object> d = hit.getSource();
							if (null != d && d.size() > 0 ) {
								JSONObject jsonObject = new JSONObject();
								d.put("id", hit.getId());
								jsonObject.put("id", d.get("id"));
								jsonObject.put("idCard", d.get("id_card"));
								jsonObject.put("avatar", d.get("avatar"));
								jsonObject.put("usedName", d.get("used_name"));
								jsonObject.put("name", d.get("name"));
								jsonObject.put("phone", d.get("phone"));
								jsonObject.put("sex", d.get("sex"));
								jsonObject.put("nation", d.get("nation"));
								jsonObject.put("education", d.get("education"));
								jsonObject.put("nativePlace", d.get("native_place"));
								jsonObject.put("birthDate", d.get("birth_date"));
								jsonObject.put("politicalOutlook", d.get("political_outlook"));
								jsonObject.put("achievement", d.get("achievement"));
								jsonObject.put("faith", d.get("faith"));
								jsonObject.put("initialAddress", d.get("initial_address"));
								jsonObject.put("maritalStatus", d.get("marital_status"));
								jsonObject.put("workplace", d.get("workplace"));
								jsonObject.put("tag", d.get("tag"));
								jsonObject.put("localPolice", d.get("local_police"));
								list.add(jsonObject);
							}
						}
					}
				}
				map.put("countS", set.size());
				map.put("list", list);
				return map;
			}else{
				map.put("countS", 0);
			}
		}
	
		return map;
	}
	
	/**
	 * 根据身份证查询车辆信息
	 * @param idCard
	 * @return
	 */
	public Map<String, Object> getCarByIdCard(String idCard){
		MongoCollection<Document> conllections = MongoManager.getMongoDatabase().getCollection("car_infor");
		FindIterable<Document> docIte= conllections.find(new BasicDBObject().append("id_card", idCard));
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
