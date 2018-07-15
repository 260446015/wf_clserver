package com.zkjl.wf_clserver.core.service;

import com.alibaba.fastjson.JSONObject;
import org.bson.Document;

import java.util.List;

/**
 * @author ydw
 * Created on 2018/6/27
 */
public abstract class AnalysisAbstractService {
    protected JSONObject analysis(String word1, String word2) {
        JSONObject result = new JSONObject();
        List<List<Document>> cacheDatasByJobId = getCacheDatasByJobId(word1, word2);
        result.putAll(analysisSameAccount(cacheDatasByJobId));
        result.putAll(analysisSameCase(cacheDatasByJobId));
        result.putAll(analysisSameRoom(cacheDatasByJobId));
        result.putAll(analysisSameInet(cacheDatasByJobId));
        result.putAll(analysisSameViolation(cacheDatasByJobId));
        result.putAll(analysisSameWork(cacheDatasByJobId));
        result.putAll(analysisSamePhone(word1, word2));
        result.putAll(analysisSameAddress(cacheDatasByJobId));
        result.putAll(analysisSameMember(cacheDatasByJobId));
        return result;
    }

    /**
     * 同会员
     */
    protected abstract JSONObject analysisSameMember(List<List<Document>> datas);

    /**
     * 同住址
     */
    protected abstract JSONObject analysisSameAddress(List<List<Document>> datas);

    /**
     * 同手机号
     */
    protected abstract JSONObject analysisSamePhone(String word1, String word2);

    /**
     * 同单位
     */
    protected abstract JSONObject analysisSameWork(List<List<Document>> datas);

    /**
     * 同车违章
     */
    protected abstract JSONObject analysisSameViolation(List<List<Document>> datas);

    /**
     * 同上网
     */
    protected abstract JSONObject analysisSameInet(List<List<Document>> datas);

    /**
     * 同住
     */
    protected abstract JSONObject analysisSameRoom(List<List<Document>> datas);

    /**
     * 同案
     */
    protected abstract JSONObject analysisSameCase(List<List<Document>> datas);

    /**
     * 同户
     */
    protected abstract JSONObject analysisSameAccount(List<List<Document>> datas);

    /**
     * 获取数据库中缓存数据
     *
     * @param jobid1
     * @param jobid2
     * @return
     */
    protected abstract List<List<Document>> getCacheDatasByJobId(String jobid1, String jobid2);

    /**
     * 获取目标数据
     */

}
