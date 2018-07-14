package com.zkjl.wf_clserver.core.util;

import org.apache.commons.lang.StringUtils;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KindDataUtil {

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
}
