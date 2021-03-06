package com.zkjl.wf_clserver.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.zkjl.wf_clserver.core.entity.Confs;
import com.zkjl.wf_clserver.core.entity.JobBean;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.repository.es.FileUploadEntityRepository;
import com.zkjl.wf_clserver.core.repository.kklc.ConfsRepository;
import com.zkjl.wf_clserver.core.repository.kklc.JobBeanRepository;
import com.zkjl.wf_clserver.core.service.AnalysisAbstractService;
import com.zkjl.wf_clserver.core.service.ElementAnalysisService;
import com.zkjl.wf_clserver.core.util.KindDataUtil;
import com.zkjl.wf_clserver.core.util.OriginTest;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ydw
 * Created on 2018/6/27
 */
@Service
public class ElementAnalysisServiceImpl extends AnalysisAbstractService implements ElementAnalysisService {

    @Resource(name = "primaryMongoTemplate")
    private MongoTemplate primaryMongoTemplate;
    @Resource
    private ConfsRepository confsRepository;

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
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameAddress", null);
        try {
            List<List<Document>> kindDatas = KindDataUtil.getKindDatas(datas, "yunsou", "同住址");
            Map data1 = (Map) kindDatas.get(0).get(0).get("data");
            Map data2 = (Map) kindDatas.get(1).get(0).get("data");
            List<ArrayList> list1 = (List) data1.get("data");
            List<ArrayList> list2 = (List) data2.get("data");
            String address1 = list1.get(0).get(7).toString();
            String address2 = list2.get(0).get(7).toString();
            if (address1.equals(address2)) {
                data1.put("source", "yunsou");
                data1.put("label", "同住址");
                data1.put("data", list1.get(0));
                jsonArray.add(data1);
                jsonObject.put("sameAddress", jsonArray);
            }
        } catch (Exception e) {
            logger.error("查询同住址出现异常:", e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSamePhone(String jobid1, String jobid2) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("samePhone", null);
        List<JobBean> jobBeans1 = primaryMongoTemplate.find(new Query(Criteria.where("jobid").is(jobid1)).with(Sort.by(Sort.Direction.DESC, "exetime")), JobBean.class, "coll_jobs");
        List<JobBean> jobBeans2 = primaryMongoTemplate.find(new Query(Criteria.where("jobid").is(jobid2)).with(Sort.by(Sort.Direction.DESC, "exetime")), JobBean.class, "coll_jobs");
        JobBean jobBean1 = jobBeans1.get(0);
        JobBean jobBean2 = jobBeans2.get(0);
        String word1 = jobBean1.getWord();
        String word2 = jobBean2.getWord();
        String reg = "^[1][3,4,5,7,8][0-9]{9}$";
        if(!word1.matches(reg)){
            return jsonObject;
        }
        List<List<Document>> cacheDatasByJobId = getCacheDatasByJobId(jobid1, jobid2);
        List<Document> targetData1 = new ArrayList<>();
        List<Document> targetData2 = new ArrayList<>();
        SysUser principal = (SysUser) SecurityUtils.getSubject().getPrincipal();
        List<Confs> confs = confsRepository.findBySystemuser(principal.getUsername());
        cacheDatasByJobId.get(0).forEach(action3 -> {
            List<Confs> resid = confs.stream().filter(action -> action.getId().equals(action3.getString("resid"))).collect(Collectors.toList());
            String platformName = "";
            if (resid.size() != 0) {
                platformName = resid.get(0).getPlatformName();
            }
            List<Document> action4 = (List<Document>) action3.get("data");
            getTargetPhone(word1, targetData1, action4, platformName);
        });
        cacheDatasByJobId.get(1).forEach(action3 -> {
            List<Confs> resid = confs.stream().filter(action -> action.getId().equals(action3.getString("resid"))).collect(Collectors.toList());
            String platformName = "";
            if (resid.size() != 0) {
                platformName = resid.get(0).getPlatformName();
            }
            List<Document> action4 = (List<Document>) action3.get("data");
            getTargetPhone(word2, targetData2, action4, platformName);
        });
        String reg2 = "(^\\d{18}$)|(^\\d{15}$)";
        Set<Document> resultData = new HashSet<>();
        targetData2.forEach(action -> {
            Document document = (Document) action.get("data");
            List<Object> data = (List<Object>) document.get("data");
            data.forEach(action2 -> {
                List<Object> list = (List<Object>) action2;
                list.forEach(action3 -> {
                    if (null != action3) {
                        if (action3.toString().matches(reg2)) {
                            targetData1.forEach(action4 -> {
                                Document document2 = (Document) action4.get("data");
                                List<Object> data2 = (List<Object>) document2.get("data");
                                data2.forEach(action5 -> {
                                    List<Object> list2 = (List<Object>) action5;
                                    list2.forEach(action6 -> {
                                        if (null != action6) {
                                            if (action6.toString().matches(reg2)) {
                                                if (action6.toString().equals(action3.toString())) {
                                                    resultData.add(action);
                                                    resultData.add(action4);
                                                }
                                            }
                                        }
                                    });
                                });
                            });
                        }
                    }
                });
            });
        });
        if (resultData.size() != 0) {
            jsonObject.put("samePhone", resultData);
        }
        return jsonObject;
    }

    private void getTargetPhone(String word, List<Document> targetData2, List<Document> action4, String platformName) {
        action4.forEach(action5 -> {
            Document document = (Document) action5.get("data");
            List<List<Object>> action6 = (List<List<Object>>) document.get("data");
            for (List<Object> strList : action6) {
                strList.forEach(str -> {
                    if (null != str) {
                        if (str.toString().equals(word)) {
                            action5.put("platformName", platformName);
                            targetData2.add(action5);
                            System.out.println(str);
                        }
                    }
                });
            }
        });
    }

    @Override
    protected JSONObject analysisSameWork(List<List<Document>> datas) {
        if (datas.size() == 0) {
            throw new RuntimeException();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameWork", null);
        try {
            JSONArray jsonArray = new JSONArray();
            List<ArrayList> workList = Lists.newArrayList();
            List<List<Document>> kindDatas = KindDataUtil.getKindDatas(datas, "yunsou", "同机构");
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
                    data1.put("source", "yunsou");
                    data1.put("label", "同机构");
                    data1.put("data", datum);
                    jsonArray.add(data1);
                }
            }
            try {
                List<List<Document>> qdkindDatas = KindDataUtil.getKindDatas(datas, "sdgayjs", "同单位");

                Map data = (Map) qdkindDatas.get(0).get(0).get("data");
                List<ArrayList> list = (List) data.get("data");
                for (int i = 0; i < list.size(); i++) {
                    List datum = list.get(i);
                    String id = (String) datum.get(1);
                    if (id.equals(idcard)) {
                        data.put("source", "sdgayjs");
                        data.put("label", "同单位");
                        data.put("data", datum);
                        jsonArray.add(data);
                    }
                }
            } catch (Exception e) {
                logger.error("查询同机构出现异常:", e.getMessage());
            }
            if (workList.size() > 0) {
                jsonObject.put("sameWork", jsonArray);
            }
        } catch (Exception e) {
            logger.error("查询同机构出现异常:", e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameViolation(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameViolation", null);
        JSONArray jsonArray = new JSONArray();
        List<String> idCardList = getIdCardList(datas);
        String idcard = null;
        try {
            idcard = idCardList.get(1);
        } catch (Exception e) {
            return jsonObject;
        }
        if (datas.size() == 0) {
            throw new RuntimeException();
        }
        try {
            List<List<Document>> kindDatas = KindDataUtil.getKindDatas(datas, "yunsou", "同车违章");
            Map data1 = (Map) kindDatas.get(0).get(0).get("data");
            List<ArrayList> list1 = (List) data1.get("data");
            for (int i = 0; i < list1.size(); i++) {
                List datum = list1.get(i);
                String id = (String) datum.get(7);
                if (id.equals(idcard)) {
                    data1.put("source", "yunsou");
                    data1.put("label", "同车违章");
                    data1.put("data", datum);
                    jsonArray.add(data1);
                }
            }
        } catch (Exception e) {
            logger.error("查询同车违章出现异常:", e.getMessage());
        }
        try {
            List<List<Document>> kindDatas = KindDataUtil.getKindDatas(datas, "sdgayjs", "同违章");
            Map data1 = (Map) kindDatas.get(0).get(0).get("data");
            List<ArrayList> list1 = (List) data1.get("data");
            for (int i = 0; i < list1.size(); i++) {
                List datum = list1.get(i);
                String id = (String) datum.get(1);
                if (id.equals(idcard)) {
                    data1.put("source", "sdgayjs");
                    data1.put("label", "同违章");
                    data1.put("data", datum);
                    jsonArray.add(data1);
                }
            }
        } catch (Exception e) {
            logger.error("查询同车违章出现异常:", e.getMessage());
        }

        try {
            List<List<Document>> jtkindDatas = KindDataUtil.getKindDatas(datas, "jtlhy", "公安部驾驶人基本信息");
            Map data = (Map) jtkindDatas.get(0).get(0).get("data");
            List<ArrayList> list = (List) data.get("data");
            String address = list.get(0).get(5).toString();
            Map<String, String> strMap = OriginTest.addressResolution(address);
            String province = strMap.get("province");

            List<List<Document>> jtlhykindDatas = KindDataUtil.getKindDatas(datas, "jtlhy", province + "交通违法关联信息");
            Map dataJtlhy = (Map) jtkindDatas.get(0).get(0).get("data");
            List<ArrayList> jtlhyList = (List) dataJtlhy.get("data");
            List<String> idList = new ArrayList<>();
            for (int i = 0; i < jtlhyList.size(); i++) {
                List datum = jtlhyList.get(i);
                String id = (String) datum.get(8);
                if (id.equals(idcard)) {
                    dataJtlhy.put("source", "jtlhy");
                    dataJtlhy.put("label", province + "交通违法关联信息");
                    dataJtlhy.put("data", datum);
                    jsonArray.add(dataJtlhy);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jsonArray.size() != 0) {
            jsonObject.put("sameViolation", jsonArray);
        }

        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameInet(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameInet", null);
        try {
            List<List<Document>> kindDatas = KindDataUtil.getKindDatas(datas, "sdgayjs", "山东警务云上网同记录");
            Map map = (Map) kindDatas.get(0).get(0).get("data");
            List<List> data = (List) map.get("data");
            String name = (String) data.get(0).get(4);
            Map map2 = (Map) kindDatas.get(1).get(0).get("data");
            List<List> data2 = (List) map2.get("data");
            List<List> collect = data2.stream().filter(action -> action.get(6).toString().equals(name)).sorted((a, b) -> b.get(1).toString().compareTo(a.get(1).toString())).collect(Collectors.toList());
            String name2 = (String) data2.get(0).get(4);
            List<List> collect2 = data.stream().filter(action -> action.get(6).toString().equals(name2)).sorted((a, b) -> b.get(1).toString().compareTo(a.get(1).toString())).collect(Collectors.toList());
            System.out.println(collect);
            System.out.println(collect2);
            List list = new ArrayList();
            if (collect.size() != 0) {
                list.add(collect);
            }
            if (collect2.size() != 0) {
                list.add(collect2);
            }
            if (list.size() != 0) {
                map.put("data", list);
                jsonObject.put("sameInet", map);
            }
        } catch (Exception e) {
            logger.error("解析同上网出现异常:", e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameRoom(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameRoom", null);
        try {
            JSONArray jsonArray = new JSONArray();
            List<List<Document>> kindDatas = KindDataUtil.getKindDatas(datas, "sdgayjs", "山东警务云宾馆同房间");
            List<String> idCardList = getIdCardList(datas);
            String idCard1 = idCardList.get(0);
            Map tfjMap2 = (Map) kindDatas.get(1).get(0).get("data");
            List<List> tfjList2 = (List) tfjMap2.get("data");
            tfjList2 = tfjList2.stream().filter(action -> action.get(0).toString().equals(idCard1)).sorted((a, b) -> b.get(2).toString().compareTo(a.get(2).toString())).collect(Collectors.toList());
            tfjMap2.put("source", "sdgayjs");
            tfjMap2.put("label", "山东警务云宾馆同房间");
            tfjMap2.put("data", tfjList2);
            if (tfjList2.size() != 0) {
                jsonArray.add(tfjMap2);
            }
            //查询山东警务云宾馆同宾馆
            List<List<Document>> kindDatas2 = KindDataUtil.getKindDatas(datas, "sdgayjs", "山东警务云宾馆同宾馆");
            Map tbgMap2 = (Map) kindDatas2.get(1).get(0).get("data");
            List<List> tbgList2 = (List) tfjMap2.get("data");
            tbgList2 = tbgList2.stream().filter(action -> action.get(0).toString().equals(idCard1)).sorted((a, b) -> b.get(3).toString().compareTo(b.get(3).toString())).collect(Collectors.toList());
            tbgMap2.put("source", "sdgayjs");
            tbgMap2.put("label", "山东警务云宾馆同宾馆");
            tbgMap2.put("data", tbgList2);
            if (tbgList2.size() != 0) {
                jsonArray.add(tbgMap2);
            }
            //查询宾馆疑似同住人员
            List<List<Document>> kindDatas3 = KindDataUtil.getKindDatas(datas, "sdgayjs", "宾馆疑似同住人员");
            Map ystzMap2 = (Map) kindDatas3.get(1).get(0).get("data");
            List<List> ystzList2 = (List) ystzMap2.get("data");
            ystzList2 = ystzList2.stream().filter(action -> action.get(1).toString().equals(idCard1)).sorted((a, b) -> b.get(0).toString().compareTo(b.get(0).toString())).collect(Collectors.toList());
            tbgMap2.put("source", "sdgayjs");
            ystzMap2.put("label", "宾馆疑似同住人员");
            ystzMap2.put("data", ystzList2);
            if (ystzList2.size() != 0) {
                jsonArray.add(ystzMap2);
            }
            if (jsonArray.size() != 0) {
                jsonObject.put("sameRoom", jsonArray);
            }
        } catch (Exception e) {
            logger.error("解析山东警务云宾馆同房间出现异常:", e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameCase(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameCase", null);
        try {
            List<List<Document>> kindDatas = KindDataUtil.getKindDatas(datas, "sdzfpt", "案件基本信息");

            kindDatas.get(0);
            System.out.println("-----");
        } catch (Exception e) {
            logger.error("解析案件基本信息出现异常:", e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameAccount(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameAccount", null);
        try {
            JSONArray jsonArray = new JSONArray();
            List<List<Document>> kindDatas = KindDataUtil.getKindDatas(datas, "yunsou", "同户号");
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
                    List<List<Document>> qiandu = KindDataUtil.getKindDatas(datas, "sdgayjs", "新常口同户亲属关系");
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
        List<Document> documents = primaryMongoTemplate.find(new Query(Criteria.where("jobid").is(jobId1)), Document.class, "coll_datas");
        List<Document> documents2 = primaryMongoTemplate.find(new Query(Criteria.where("jobid").is(jobId2)), Document.class, "coll_datas");
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
            List<List<Document>> kindDatas = KindDataUtil.getKindDatas(datas, "yunsou", "全国人口基本信息");

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

    @Override
    protected JSONObject analysisSameThcdc(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameThcdc", null);
        List<String> idCardList = getIdCardList(datas);
        try {
            JSONArray jsonArray = new JSONArray();
            List<List<Document>> kindDatas = KindDataUtil.getKindDatas(datas, "yunsou", "铁路同乘车");
            Map data1 = (Map) kindDatas.get(0).get(0).get("data");
            Map data2 = (Map) kindDatas.get(1).get(0).get("data");
            List<ArrayList> list1 = (List) data1.get("data");
            List<ArrayList> list2 = (List) data2.get("data");
            Set<Object> check = new HashSet<>();
            list1.forEach(action1 ->{
                String idCard1 = action1.get(7).toString();
                if(idCard1.equals(idCardList.get(1))){
                    check.add(action1);
                }
            });
            list2.forEach(action1 ->{
                String idCard1 = action1.get(7).toString();
                if(idCard1.equals(idCardList.get(0))){
                    check.add(action1);
                }
            });
            System.out.println(check);
            if(check.size() != 0){
                JSONObject data = new JSONObject();
                data.put("source","yunsou");
                data.put("label","铁路同乘车");
                data.put("column",data1.get("column"));
                data.put("data",check);
                jsonArray.add(data);
                jsonObject.put("sameThcdc", jsonArray);
            }
        } catch (Exception e) {
            logger.error("解析铁路同乘车出现异常", e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameTcj(List<List<Document>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameTcj", null);
        List<String> idCardList = getIdCardList(datas);
        try {
            JSONArray jsonArray = new JSONArray();
            List<List<Document>> kindDatas = KindDataUtil.getKindDatas(datas, "yunsou", "同乘机");
            Map data1 = (Map) kindDatas.get(0).get(0).get("data");
            Map data2 = (Map) kindDatas.get(1).get(0).get("data");
            List<ArrayList> list1 = (List) data1.get("data");
            List<ArrayList> list2 = (List) data2.get("data");
            Set<Object> check = new HashSet<>();
            list1.forEach(action1 ->{
                String idCard1 = action1.get(7).toString();
                if(idCard1.equals(idCardList.get(1))){
                    check.add(action1);
                }
            });
            list2.forEach(action1 ->{
                String idCard1 = action1.get(7).toString();
                if(idCard1.equals(idCardList.get(0))){
                    check.add(action1);
                }
            });
            System.out.println(check);
            if(check.size() != 0){
                JSONObject data = new JSONObject();
                data.put("source","yunsou");
                data.put("label","铁路同乘车");
                data.put("column",data1.get("column"));
                data.put("data",check);
                jsonArray.add(data);
                jsonObject.put("sameThcdc", jsonArray);
            }
        } catch (Exception e) {
            logger.error("解析铁路同乘车出现异常", e.getMessage());
        }
        return jsonObject;
    }
}
