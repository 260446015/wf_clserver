package com.zkjl.wf_clserver.core.service.impl;

import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.entity.CollDatas;
import com.zkjl.wf_clserver.core.repository.plover.CollDatasRepository;
import com.zkjl.wf_clserver.core.repository.plover.JobBeanRepository;
import com.zkjl.wf_clserver.core.service.AnalysisAbstractService;
import com.zkjl.wf_clserver.core.service.ElementAnalysisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author ydw
 * Created on 2018/6/27
 */
@Service
public class ElementAnalysisServiceImpl extends AnalysisAbstractService implements ElementAnalysisService{

    @Resource
    private JobBeanRepository jobBeanRepository;
    @Resource
    private CollDatasRepository collDatasRepository;
    @Override
    public ApiResult analysis(String jobId1, String jobId2) {
        return  super.analysis(jobId1,jobId2);
    }

    @Override
    protected void analysisSameMember() {

    }

    @Override
    protected void analysisSameAddress() {

    }

    @Override
    protected void analysisSamePhone() {

    }

    @Override
    protected void analysisSameWork() {

    }

    @Override
    protected void analysisSameViolation() {

    }

    @Override
    protected void analysisSameInet() {

    }

    @Override
    protected void analysisSameRoom() {

    }

    @Override
    protected void analysisSameCase() {

    }

    @Override
    protected void analysisSameAccount() {

    }

    @Override
    protected Map<String, List<Object>> getCacheDatasByJobId() {
        List<CollDatas> collDatas1 = collDatasRepository.findByJobid("YVyr1kZ7X6erYyPBeV5");
        System.out.println(collDatas1);
        return null;
    }
}
