package com.zkjl.wf_clserver.core.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KindDataUtil {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(KindDataUtil.class);

    public static List<List<Document>> getKindDatas(List<List<Document>> datas, String platKind, String label) {
        List<List<Document>> resultDatas = new ArrayList<>(2);
        List<Document> datas1 = datas.get(0).stream().filter(action -> action.getString("resid").equals(platKind)).collect(Collectors.toList());
        List<Document> datas2 = datas.get(1).stream().filter(action -> action.getString("resid").equals(platKind)).collect(Collectors.toList());
        List<Document> document1 = (List<Document>) datas1.get(0).get("data");
        List<Document> document2 = (List<Document>) datas2.get(0).get("data");
        if(!StringUtils.isBlank(label)){
            document1 = document1.stream().filter(action -> action.getString("label").equals(label)).collect(Collectors.toList());
            document2 = document2.stream().filter(action -> action.getString("label").equals(label)).collect(Collectors.toList());
        }
        resultDatas.add(document1);
        resultDatas.add(document2);
        return resultDatas;
    }

    public static List<Document> getKindData(List<Document> datas, String platKind, String label) {
        List<Document> document1=Lists.newArrayList();
        try {
        List<Document> datas1 = datas.stream().filter(action -> action.getString("resid").equals(platKind)).sorted((a, b) -> b.get("exetime").toString().compareTo(b.get("exetime").toString())).limit(1).collect(Collectors.toList());
        document1 = (List<Document>) datas1.get(0).get("data");
        if(!StringUtils.isBlank(label)){
            document1 = document1.stream().filter(action -> action.getString("label").equals(label)).collect(Collectors.toList());
        }
        } catch (Exception e) {
            logger.error("数据查询出现异常:", e.getMessage());
        }
        return document1;
    }

    public static List<ArrayList> getTrackData(List<Document> documents, String platKind, String label) {
        List<ArrayList> result = Lists.newArrayList();
        try {
            List<Document> staykindDatas = KindDataUtil.getKindData(documents, platKind, label);
            Map data1 = (Map) staykindDatas.get(0).get("data");
            ArrayList columns= (ArrayList) data1.get("column");
            ArrayList datas = (ArrayList) data1.get("data");
            result.add(columns);
            result.add(datas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
