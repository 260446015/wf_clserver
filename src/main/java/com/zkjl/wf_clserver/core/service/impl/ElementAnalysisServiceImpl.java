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
        return null;
    }

    @Override
    protected JSONObject analysisSameAddress(List<List<Document>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSamePhone(List<List<Document>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSameWork(List<List<Document>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSameViolation(List<List<Document>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSameInet(List<List<Document>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSameRoom(List<List<Document>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSameCase(List<List<Document>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSameAccount(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameAccount",null);
        try {
            getKindDatas(datas,"sdgayjs","新常住人口");
//            datas.stream().filter()
            System.out.println(datas);
        } catch (Exception e) {
            e.printStackTrace();
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
