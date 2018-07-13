package com.zkjl.wf_clserver.core.service.impl;

import com.alibaba.fastjson.JSONObject;
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
        jsonObject.put("sameMember",null);
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameAddress(List<List<Document>> datas) {
        if (datas.size() == 0) {
            throw new RuntimeException();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameAddress",null);
        try {
            List<List<Document>> kindDatas = getKindDatas(datas, "yunsou", "同住址");
            String address1 = kindDatas.get(0).get(0).get("data").toString();
            String address2 = kindDatas.get(1).get(0).get("data").toString();
            if(address1.equals(address2)){
                jsonObject.put("sameAddress",address1);
            }
        } catch (Exception e) {
            logger.error("查询同住址出现异常:",e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSamePhone(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("samePhone",null);
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameWork(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameWork",null);
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameViolation(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameViolation",null);
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameInet(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameInet",null);
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameRoom(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameRoom",null);
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameCase(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameCase",null);
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameAccount(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameAccount",null);
        try {
            List<List<Document>> kindDatas = getKindDatas(datas, "yunsou", "同户号");
            Map data1 = (Map) kindDatas.get(0).get(0).get("data");
            Map data2 = (Map) kindDatas.get(1).get(0).get("data");
            List<ArrayList> list1 = (List) data1.get("data");
            List<ArrayList> list2 = (List) data2.get("data");
            String account1 = (String) list1.get(0).get(7);
            String account2 = (String) list2.get(0).get(7);
            if(account1.equals(account2)){
                jsonObject.put("sameAccount",list1);
            }
        } catch (Exception e) {
            logger.error("解析同户号出现异常",e.getMessage());
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

}
