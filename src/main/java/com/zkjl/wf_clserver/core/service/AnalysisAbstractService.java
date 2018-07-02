package com.zkjl.wf_clserver.core.service;

import com.zkjl.wf_clserver.core.common.ApiResult;

import java.util.List;
import java.util.Map;

/**
 * @author ydw
 * Created on 2018/6/27
 */
public abstract class AnalysisAbstractService {
    protected ApiResult analysis(String jobId1,String jobId2){
        //获取数据库中缓存数据
        Map<String,List<Object>> dataMap = getCacheDatasByJobId();
        //同户
        analysisSameAccount();
        //同案
        analysisSameCase();
        //同住
        analysisSameRoom();
        //同上网
        analysisSameInet();
        //同车违章
        analysisSameViolation();
        //同单位
        analysisSameWork();
        //同手机号
        analysisSamePhone();
        //同住址
        analysisSameAddress();
        //同会员
        analysisSameMember();
        return null;
    }

    protected abstract void analysisSameMember();

    protected abstract void analysisSameAddress();

    protected abstract void analysisSamePhone();

    protected abstract void analysisSameWork();

    protected abstract void analysisSameViolation();

    protected abstract void analysisSameInet();

    protected abstract void analysisSameRoom();

    protected abstract void analysisSameCase();

    protected abstract void analysisSameAccount();

    protected abstract Map<String,List<Object>> getCacheDatasByJobId();
}
