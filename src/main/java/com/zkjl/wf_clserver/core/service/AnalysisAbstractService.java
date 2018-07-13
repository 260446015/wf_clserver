package com.zkjl.wf_clserver.core.service;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.entity.CollDatas;
import com.zkjl.wf_clserver.core.entity.CollDatasInner;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ydw
 * Created on 2018/6/27
 */
public abstract class AnalysisAbstractService {
    protected JSONObject analysis(String word1, String word2) {
        JSONObject result = new JSONObject();
        List<List<CollDatas>> cacheDatasByJobId = getCacheDatasByJobId(word1, word2);
        result.putAll(analysisSameAccount(cacheDatasByJobId));
        result.putAll(analysisSameCase(cacheDatasByJobId));
        result.putAll(analysisSameRoom(cacheDatasByJobId));
        result.putAll(analysisSameInet(cacheDatasByJobId));
        result.putAll(analysisSameViolation(cacheDatasByJobId));
        result.putAll(analysisSameWork(cacheDatasByJobId));
        result.putAll(analysisSamePhone(cacheDatasByJobId));
        result.putAll(analysisSameAddress(cacheDatasByJobId));
        result.putAll(analysisSameMember(cacheDatasByJobId));
        return result;
    }

    protected List<List<CollDatasInner>> getKindDatas(List<List<CollDatas>> datas, String platKind, String label) {
        List<List<CollDatasInner>> resultDatas = new ArrayList<>(2);
        List<CollDatas> datas1 = datas.get(0).stream().filter(action -> action.getResid().equals(platKind)).collect(Collectors.toList());
        List<CollDatas> datas2 = datas.get(1).stream().filter(action -> action.getResid().equals(platKind)).collect(Collectors.toList());
        List<CollDatasInner> collDatasInners1 = datas1.get(0).getData();
        List<CollDatasInner> collDatasInners2 = datas2.get(0).getData();
        if(!StringUtils.isBlank(label)){
            collDatasInners1 = datas1.get(0).getData().stream().filter(action -> action.getLabel().equals(label)).collect(Collectors.toList());
            collDatasInners2 = datas2.get(0).getData().stream().filter(action -> action.getLabel().equals(label)).collect(Collectors.toList());
        }
        resultDatas.add(collDatasInners1);
        resultDatas.add(collDatasInners2);
        return resultDatas;
    }

    /**
     * 同会员
     */
    protected abstract JSONObject analysisSameMember(List<List<CollDatas>> datas);

    /**
     * 同住址
     */
    protected abstract JSONObject analysisSameAddress(List<List<CollDatas>> datas);

    /**
     * 同手机号
     */
    protected abstract JSONObject analysisSamePhone(List<List<CollDatas>> datas);

    /**
     * 同单位
     */
    protected abstract JSONObject analysisSameWork(List<List<CollDatas>> datas);

    /**
     * 同车违章
     */
    protected abstract JSONObject analysisSameViolation(List<List<CollDatas>> datas);

    /**
     * 同上网
     */
    protected abstract JSONObject analysisSameInet(List<List<CollDatas>> datas);

    /**
     * 同住
     */
    protected abstract JSONObject analysisSameRoom(List<List<CollDatas>> datas);

    /**
     * 同案
     */
    protected abstract JSONObject analysisSameCase(List<List<CollDatas>> datas);

    /**
     * 同户
     */
    protected abstract JSONObject analysisSameAccount(List<List<CollDatas>> datas);

    /**
     * 获取数据库中缓存数据
     *
     * @param jobid1
     * @param jobid2
     * @return
     */
    protected abstract List<List<CollDatas>> getCacheDatasByJobId(String jobid1, String jobid2);

    /**
     * 获取目标数据
     */

}
