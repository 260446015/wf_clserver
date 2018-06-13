package com.zkjl.wf_clserver.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.service.TcgnicalSupervisionService;
import com.zkjl.wf_clserver.core.util.JdbcUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("tcgnicalSupervisionService")
public class TcgnicalSupervisionImpl implements TcgnicalSupervisionService {

	private static final long serialVersionUID = -7377695482669420844L;

	/** 封装线 */
	private static JSONObject getPointLineJson(List<Map<String, Object>> result) {
		Map<Integer, Map<String, Object>> pointMap = new HashMap<Integer, Map<String, Object>>();
		Map<String, String> lineMap = new HashMap<String, String>();

		for (Map<String, Object> resultMap : result) {
			Set<String> keySet = resultMap.keySet();
			for (String key : keySet) {
				Map<String, Object> resulValueMap = (Map<String, Object>) resultMap.get(key);
				// 封装点map 根据ID去重
				// {66={id=66, category=1, name=福建, labels=Company,
				// symbolSize=40}, 68={id=68, category=1, name=湖北,
				// labels=Company, symbolSize=40}}
				if (key.startsWith("n")) {
					Integer id = Integer.parseInt(String.valueOf(resulValueMap.get("_id")));
					if (pointMap.get(id) == null) {
						Map<String, Object> map = new HashMap<String, Object>();
						// 定义标签ID
						map.put("id", id);
						String labels = ((List<String>) resulValueMap.get("_labels")).get(0);
						map.put("labels", labels);
						// 类别
						int category = 0;
						map.put("value", resulValueMap.get("name"));
						// 评论不显示名称，标签大小固定为8
						if ("Comments".equals(labels)) {
							category = 3;
							map.put("symbolSize", 8);
						} else {
							map.put("name", resulValueMap.get("name"));
							// 演员
							if ("Actor".equals(labels)) {
								category = 0;
								// 导演
							} else if ("Director".equals(labels)) {
								category = 1;
								// 电影
							} else if ("Movie".equals(labels)) {
								category = 2;
							}
						}
						// 类别
						map.put("category", category);
						pointMap.put(id, map);
					}

					// 封装线Map 根据startId-->endId去重
					// {30-->60=, 30-->84=}
				} else if (key.startsWith("r")) {
					lineMap.put(resulValueMap.get("_startId") + "-->" + resulValueMap.get("_endId"), "");
				} else {
					System.out.println("返回的结果集请以 'n' 或者 'r' 开头！！！");
				}
			}
		}

		// 转Json
		return mapToJson(lineMap, pointMap);
	}

	/** 转json */
	private static JSONObject mapToJson(Map<String, String> lineMap, Map<Integer, Map<String, Object>> pointMap) {
		JSONObject jsonObject = new JSONObject();
		JSONArray lineJsonArray = new JSONArray();

		for (String key : lineMap.keySet()) {
			String[] split = key.split("-->");
			JSONObject lineJsonObject = new JSONObject();
			lineJsonObject.put("source", split[0]);
			lineJsonObject.put("target", split[1]);
			lineJsonArray.add(lineJsonObject);
		}
		// 点集合
		// "data":[{"id":66,"category":1,"name":"福建","labels":"Company","symbolSize":40},{"id":68,"category":1,"name":"湖北","labels":"Company","symbolSize":40}]
		jsonObject.put("data",pointMap.values());
//		jsonObject.element("data", pointMap.values());
		// 线集合
		// "links":[{"source":'7',"target":'2'},{"source":'3',"target":'2'}]
//		jsonObject.element("links", lineJsonArray);
		jsonObject.put("links",pointMap.values());
		return jsonObject;
	}

	/** 根据查询条件查询数据转换为页面需要的JSON */
	@Override
	public JSONObject find(ArrayList<String> list, String isQuestion) {
		String cypher = findCypher(list, isQuestion);
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection();
		JSONObject json = null;
		List<Map<String, Object>> result = null;
		try {
			// 查询结果集
			if (!"".equals(cypher)) {
				result = jdbcUtil.findList(cypher);
				// 查询结果集转为json
				json = getPointLineJson(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != jdbcUtil) {
				jdbcUtil.close();
			}
		}
		return json;
	}

	/** 将查询条件转换为cypher语句 */
	private String findCypher(ArrayList<String> list, String isQuestion) {
		String cypher = "";

		// 如果页面问题选项打钩，则返回问题节点
		String q = "";
		if ("1".equals(isQuestion)) {
			q = ",rq,nq";
		}

		// 判断查询条件数量写不同cql语句
		if (list.size() == 0) {
			cypher = "match (na:Actor)-[r1]-(nb:Director)-[r2]-(nc:Movie)-[rq]-(nq:Comments) return na,nb,nc,r1,r2 limit 1000";
		} else if (list.size() == 1) {
			String key = list.get(0).split("~~~")[0];
			String value = list.get(0).split("~~~")[1];
			cypher = "match (na:" + key + ")-[rq]-(nq:Comments) where 1=1 ";
			if (!value.contains("all")) {
				cypher += " and id(na) in " + value;
			}
			cypher += " return na" + q;
		} else if (list.size() == 2) {
			String key1 = list.get(0).split("~~~")[0];
			String key2 = list.get(1).split("~~~")[0];
			String value1 = list.get(0).split("~~~")[1];
			String value2 = list.get(1).split("~~~")[1];

			cypher = "match (na:" + key1 + ")-[r]-(nb:" + key2 + ")-[rq]-(nq:Comments),(na)--(nq) where 1=1 ";
			if (!value1.contains("all")) {
				cypher += " and id(na) in " + value1;
			}
			if (!value2.contains("all")) {
				cypher += " and id(nb) in " + value2;
			}
			cypher += " return na,r,nb" + q;
		} else if (list.size() == 3) {
			String key1 = list.get(0).split("~~~")[0];
			String key2 = list.get(1).split("~~~")[0];
			String key3 = list.get(2).split("~~~")[0];
			String value1 = list.get(0).split("~~~")[1];
			String value2 = list.get(1).split("~~~")[1];
			String value3 = list.get(2).split("~~~")[1];

			cypher = "match (na:" + key1 + ")-[r]-(nb:" + key2 + ")-[r2]-(nc:" + key3
					+ ")-[rq]-(nq:Comments),(na)--(nq),(na)--(nc),(nb)--(nq) where 1=1 ";
			if (!value1.contains("all")) {
				cypher += " and id(na) in " + value1;
			}
			if (!value2.contains("all")) {
				cypher += " and id(nb) in " + value2;
			}
			if (!value3.contains("all")) {
				cypher += " and id(nc) in " + value3;
			}
			cypher += " return na,r,nb,r2,nc" + q;

		}

		return cypher;
	}

	/** 查询页面下拉框内容 */
	@Override
	public JSONObject findLables() {
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection();
		JSONObject json = new JSONObject();
		List<Map<String, Object>> result = null;
		try {
			// 查询结果集
			result = jdbcUtil
					.findList("match (na) where labels(na) in ['Actor','Director','Movie'] return labels(na)[0] as label,na.name as name,id(na) as value ");

			HashMap<String, List<HashMap<String, String>>> labelsMap = new HashMap<String, List<HashMap<String, String>>>();
			for (Map<String, Object> map : result) {
				HashMap<String, String> hashMap = new HashMap<String, String>();
				hashMap.put("name", String.valueOf(map.get("name")));
				hashMap.put("value", String.valueOf(map.get("value")));

				// 标签第一次进集合，添加全部和第一条
				if (labelsMap.get(map.get("label")) == null) {
					ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
					HashMap<String, String> hashAll = new HashMap<String, String>();
					hashAll.put("name", "全部");
					hashAll.put("value", "all");
					arrayList.add(hashAll);
					arrayList.add(hashMap);
					labelsMap.put(map.get("label").toString(), arrayList);
				} else {
					// 如果标签已经存在，则添加下拉框内容
					List<HashMap<String, String>> list = labelsMap.get(map.get("label"));
					list.add(hashMap);
				}
			}
			json.putAll(labelsMap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != jdbcUtil) {
				jdbcUtil.close();
			}
		}
		return json;
	}
}
