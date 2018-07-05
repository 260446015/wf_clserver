package com.zkjl.wf_clserver.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.entity.CollDatas;
import com.zkjl.wf_clserver.core.entity.CollDatasInner;
import com.zkjl.wf_clserver.core.repository.plover.CollDatasRepository;
import com.zkjl.wf_clserver.core.repository.plover.JobBeanRepository;
import com.zkjl.wf_clserver.core.service.AnalysisAbstractService;
import com.zkjl.wf_clserver.core.service.ElementAnalysisService;
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

    @Resource
    private CollDatasRepository collDatasRepository;

    @Override
    public ApiResult analysis(String jobId1, String jobId2) {
        return super.analysis(jobId1, jobId2);
    }

    @Override
    protected void analysisSameMember(List<List<CollDatas>> datas) {

    }

    @Override
    protected void analysisSameAddress(List<List<CollDatas>> datas) {

    }

    @Override
    protected void analysisSamePhone(List<List<CollDatas>> datas) {

    }

    @Override
    protected void analysisSameWork(List<List<CollDatas>> datas) {
        String idcard = datas.get(0).get(0).getData().get(0).getData().getData()[0][7];
        List<List<CollDatasInner>> kindDatas = getKindDatas(datas, "yunsou", "同机构");
        List<CollDatasInner> collDatasInners2 = kindDatas.get(1);
        String[][] data = collDatasInners2.get(0).getData().getData();
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            String[] datum = data[i];
            String id = datum[0];
            ids.add(id);
        }
        if(ids.contains(idcard)){
            System.out.println("同一个单位");
        }
    }

    @Override
    protected void analysisSameViolation(List<List<CollDatas>> datas) {

    }

    @Override
    protected void analysisSameInet(List<List<CollDatas>> datas) {

    }

    @Override
    protected void analysisSameRoom(List<List<CollDatas>> datas) {

    }

    @Override
    protected void analysisSameCase(List<List<CollDatas>> datas) {

    }

    @Override
    protected void analysisSameAccount(List<List<CollDatas>> datas) {
        if (datas.size() == 0) {
            throw new RuntimeException();
        }
        List<List<CollDatasInner>> kindDatas = getKindDatas(datas, "yunsou", "同户号");
        String account1 = kindDatas.get(0).get(0).getData().getData()[0][7];
        String account2 = kindDatas.get(1).get(0).getData().getData()[0][7];
        System.out.println("account1:"+account1);
        System.out.println("account2:"+account2);
        if(account1.equals(account2)){
            System.out.println("含有相同户号");
        }
        System.out.println("!!!!!!!!!!");

    }

    @Override
    protected List<List<CollDatas>> getCacheDatasByJobId(String jobId1, String jobId2) {
        List<List<CollDatas>> list = new ArrayList<>(2);
        List<CollDatas> collDatas1 = collDatasRepository.findByJobid(jobId1);
        List<CollDatas> collDatas2 = collDatasRepository.findByJobid(jobId2);
        List<CollDatas> filterList1 = collDatas1.stream().filter(action -> action.getData().size() != 0).collect(Collectors.toList());
        List<CollDatas> filterList2 = collDatas2.stream().filter(action -> action.getData().size() != 0).collect(Collectors.toList());
        list.add(filterList1);
        list.add(filterList2);
        return list;
    }

}
