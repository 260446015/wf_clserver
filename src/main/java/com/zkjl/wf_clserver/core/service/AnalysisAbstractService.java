package com.zkjl.wf_clserver.core.service;

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
    protected ApiResult analysis(String jobId1, String jobId2) {
        List<List<CollDatas>> cacheDatasByJobId = getCacheDatasByJobId(jobId1, jobId2);
        analysisSameAccount(cacheDatasByJobId);
        analysisSameCase(cacheDatasByJobId);
        analysisSameRoom(cacheDatasByJobId);
        analysisSameInet(cacheDatasByJobId);
        analysisSameViolation(cacheDatasByJobId);
        analysisSameWork(cacheDatasByJobId);
        analysisSamePhone(cacheDatasByJobId);
        analysisSameAddress(cacheDatasByJobId);
        analysisSameMember(cacheDatasByJobId);
        return null;
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
    protected abstract void analysisSameMember(List<List<CollDatas>> datas);

    /**
     * 同住址
     */
    protected abstract void analysisSameAddress(List<List<CollDatas>> datas);

    /**
     * 同手机号
     */
    protected abstract void analysisSamePhone(List<List<CollDatas>> datas);

    /**
     * 同单位
     */
    protected abstract void analysisSameWork(List<List<CollDatas>> datas);

    /**
     * 同车违章
     */
    protected abstract void analysisSameViolation(List<List<CollDatas>> datas);

    /**
     * 同上网
     */
    protected abstract void analysisSameInet(List<List<CollDatas>> datas);

    /**
     * 同住
     */
    protected abstract void analysisSameRoom(List<List<CollDatas>> datas);

    /**
     * 同案
     */
    protected abstract void analysisSameCase(List<List<CollDatas>> datas);

    /**
     * 同户
     */
    protected abstract void analysisSameAccount(List<List<CollDatas>> datas);

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
