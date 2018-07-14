package com.zkjl.wf_clserver.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.zkjl.wf_clserver.core.service.AnalysisAbstractService;
import com.zkjl.wf_clserver.core.service.ElementAnalysisService;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ydw
 * Created on 2018/6/27
 */
@Service
public class ElementAnalysisServiceImpl extends AnalysisAbstractService implements ElementAnalysisService {

    @Resource(name = "secondaryMongoTemplate")
    private MongoTemplate secondMongoTemplate;

    private static Logger logger = LoggerFactory.getLogger(ElementAnalysisServiceImpl.class);

    @Override
    public JSONObject analysis(String word1, String word2) {
        return super.analysis(word1, word2);
    }

    @Override
    protected JSONObject analysisSameMember(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameMember", null);
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameAddress(List<List<Document>> datas) {
        if (datas.size() == 0) {
            throw new RuntimeException();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameAddress", null);
        try {
            List<List<Document>> kindDatas = getKindDatas(datas, "yunsou", "同住址");
            Map data1 = (Map) kindDatas.get(0).get(0).get("data");
            Map data2 = (Map) kindDatas.get(1).get(0).get("data");
            List<ArrayList> list1 = (List) data1.get("data");
            List<ArrayList> list2 = (List) data2.get("data");
            String address1 = list1.get(0).get(7).toString();
            String address2 = list2.get(0).get(7).toString();
            if (address1.equals(address2)) {
                jsonObject.put("sameAddress", address1);
            }
        } catch (Exception e) {
            logger.error("查询同住址出现异常:", e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSamePhone(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("samePhone", null);
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameWork(List<List<Document>> datas) {
        if (datas.size() == 0) {
            throw new RuntimeException();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameWork", null);
        try {
            List<ArrayList> workList = Lists.newArrayList();
            List<List<Document>> kindDatas = getKindDatas(datas, "yunsou", "同机构");
            List<String> idCardList = getIdCardList(datas);
            String idcard = idCardList.get(1);
            Map data1 = (Map) kindDatas.get(0).get(0).get("data");
            List<ArrayList> list1 = (List) data1.get("data");
            List<String> ids = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                List datum = list1.get(i);
                String id = (String) datum.get(0);
                ids.add(id);
                if (id.equals(idcard)) {
                    workList.add((ArrayList) datum);
                }
            }

            List<List<Document>> qdkindDatas = getKindDatas(datas, "sdgayjs", "同单位");

            Map data = (Map) qdkindDatas.get(0).get(0).get("data");
            List<ArrayList> list = (List) data.get("data");
            for (int i = 0; i < list.size(); i++) {
                List datum = list.get(i);
                String id = (String) datum.get(1);
                if (id.equals(idcard)) {
                    workList.add((ArrayList) datum);
                }
            }
            jsonObject.put("sameWork", workList);
        } catch (Exception e) {
            logger.error("查询同机构出现异常:", e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameViolation(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameViolation", null);
        if (datas.size() == 0) {
            throw new RuntimeException();
        }
        try {
            List<List<Document>> kindDatas = getKindDatas(datas, "yunsou", "同车违章");
            List<String> idCardList = getIdCardList(datas);
            String idcard = idCardList.get(1);
            Map data1 = (Map) kindDatas.get(0).get(0).get("data");
            List<ArrayList> list1 = (List) data1.get("data");
            List<String> ids = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                List datum = list1.get(i);
                String id = (String) datum.get(7);
                ids.add(id);
                if (id.equals(idcard)) {
                    jsonObject.put("sameViolation", datum);
                }
            }
        } catch (Exception e) {
            logger.error("查询同车违章出现异常:", e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameInet(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameInet", null);
        try {
            List<List<Document>> kindDatas = getKindDatas(datas, "sdgayjs", "山东警务云上网同记录");
            List<String> idCardList = getIdCardList(datas);
            String id1 = idCardList.get(0);
            String id2 = idCardList.get(1);
            Map map = (Map) kindDatas.get(0).get(0).get("data");
            List<List> data = (List) map.get("data");
            String name = (String) data.get(0).get(4);
            Map map2 = (Map) kindDatas.get(1).get(0).get("data");
            List<List> data2 = (List) map2.get("data");
            List<List> collect = data2.stream().filter(action -> action.get(6).toString().equals(name) && (action.get(5).toString().equals(id1) || action.get(5).toString().equals(id2))).sorted((a, b) -> b.get(1).toString().compareTo(a.get(1).toString())).collect(Collectors.toList());
            String name2 = (String) data2.get(0).get(4);
            List<List> collect2 = data.stream().filter(action -> action.get(6).toString().equals(name2) && (action.get(5).toString().equals(id1) || action.get(5).toString().equals(id2))).sorted((a, b) -> b.get(1).toString().compareTo(a.get(1).toString())).collect(Collectors.toList());
            System.out.println(collect);
            System.out.println(collect2);
            List list = new ArrayList();
            list.add(collect);
            list.add(collect2);
            map.put("data", list);
            jsonObject.put("sameInet", map);
        } catch (Exception e) {
            logger.error("解析同上网出现异常:", e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameRoom(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameRoom", null);
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameCase(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameCase", null);
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameAccount(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameAccount", null);
        try {
            JSONArray jsonArray = new JSONArray();
            List<List<Document>> kindDatas = getKindDatas(datas, "yunsou", "同户号");
            Map data1 = (Map) kindDatas.get(0).get(0).get("data");
            Map data2 = (Map) kindDatas.get(1).get(0).get("data");
            List<ArrayList> list1 = (List) data1.get("data");
            List<ArrayList> list2 = (List) data2.get("data");
            String account1 = (String) list1.get(0).get(7);
            String account2 = (String) list2.get(0).get(7);
            if (account1.equals(account2)) {
                data1.put("source", "yunsou");
                jsonArray.add(data1);
                try {
                    List<List<Document>> qiandu = getKindDatas(datas, "sdgayjs", "新常口同户亲属关系");
                    Map qianduMap = (Map) qiandu.get(0).get(0).get("data");
                    qianduMap.put("source", "sdgayjs");
                    jsonArray.add(qianduMap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (jsonArray.size() != 0) {
                jsonObject.put("sameAccount", jsonArray);
            }
        } catch (Exception e) {
            logger.error("解析同户号云搜出现异常", e.getMessage());
        }
        return jsonObject;
    }


    @Override
    protected List<List<Document>> getCacheDatasByJobId(String jobId1, String jobId2) {
        List<List<Document>> list = new ArrayList<>(2);
        List<Document> documents = secondMongoTemplate.find(new Query(Criteria.where("jobid").is(jobId1)), Document.class, "coll_datas");
        List<Document> documents2 = secondMongoTemplate.find(new Query(Criteria.where("jobid").is(jobId2)), Document.class, "coll_datas");
        list.add(documents);
        list.add(documents2);
        return list;
    }

    public List<String> getIdCardList(List<List<Document>> datas) {
        List<String> idList = Lists.newArrayList();
        if (datas.size() == 0) {
            throw new RuntimeException();
        }
        try {
            List<List<Document>> kindDatas = getKindDatas(datas, "yunsou", "全国人口基本信息");

            Map data1 = (Map) kindDatas.get(0).get(0).get("data");
            Map data2 = (Map) kindDatas.get(1).get(0).get("data");
            List<ArrayList> list1 = (List) data1.get("data");
            List<ArrayList> list2 = (List) data2.get("data");
            String idcard = list1.get(0).get(0).toString();
            idList.add(idcard);
            String idcard2 = list2.get(0).get(0).toString();
            idList.add(idcard2);
        } catch (Exception e) {
            logger.error("查询身份证号出现异常:", e.getMessage());
        }
        return idList;
    }

}
