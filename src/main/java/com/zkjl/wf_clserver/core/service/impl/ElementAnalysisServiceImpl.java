package com.zkjl.wf_clserver.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.entity.CollDatas;
import com.zkjl.wf_clserver.core.entity.CollDatasInner;
import com.zkjl.wf_clserver.core.repository.plover.CollDatasRepository;
import com.zkjl.wf_clserver.core.service.AnalysisAbstractService;
import com.zkjl.wf_clserver.core.service.ElementAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ydw
 * Created on 2018/6/27
 */
@Service
public class ElementAnalysisServiceImpl extends AnalysisAbstractService implements ElementAnalysisService {

    @Resource
    private CollDatasRepository collDatasRepository;

    private static Logger logger = LoggerFactory.getLogger(ElementAnalysisServiceImpl.class);

    @Override
    public JSONObject analysis(String jobId1, String jobId2) {
        return super.analysis(jobId1, jobId2);
    }

    @Override
    protected JSONObject analysisSameMember(List<List<CollDatas>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSameAddress(List<List<CollDatas>> datas) {
        if (datas.size() == 0) {
            throw new RuntimeException();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameAddress",null);
        try {
        List<List<CollDatasInner>> kindDatas = getKindDatas(datas, "yunsou", "同住址");
        String address1 = kindDatas.get(0).get(0).getData().getData()[0][7];
        String address2 = kindDatas.get(1).get(0).getData().getData()[0][7];
        System.out.println("address1:"+address1);
        System.out.println("address2:"+address2);
        if(address1.equals(address2)){
            jsonObject.put("sameAddress",address1);
        }
        } catch (Exception e) {
            logger.error("查询同住址出现异常:",e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSamePhone(List<List<CollDatas>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSameWork(List<List<CollDatas>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameWork",null);
        try {
        String idcard = datas.get(0).get(0).getData().get(0).getData().getData()[0][0];
        List<List<CollDatasInner>> kindDatas = getKindDatas(datas, "yunsou", "同机构");
        List<CollDatasInner> collDatasInners2 = kindDatas.get(1);
        String[][] data = collDatasInners2.get(0).getData().getData();
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            String[] datum = data[i];
            String id = datum[0];
            ids.add(id);
            if(id.equals(idcard)){
                jsonObject.put("sameWork",datum);
            }
        }
        /*if(ids.contains(idcard)){
            jsonObject.put("sameWork",kindDatas.get(0));
        }*/
        } catch (Exception e) {
            logger.error("查询同机构出现异常:",e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameViolation(List<List<CollDatas>> datas) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameWork",null);
        try {
        String idcard = datas.get(0).get(0).getData().get(0).getData().getData()[0][0];
        System.out.println("同车违章"+idcard);
        List<List<CollDatasInner>> kindDatas = getKindDatas(datas, "yunsou", "同车违章");
        System.out.println("同车违章"+kindDatas);
        List<CollDatasInner> collDatasInners2 = kindDatas.get(1);
        String[][] data = collDatasInners2.get(0).getData().getData();
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            String[] datum = data[i];
            String id = datum[7];
            ids.add(id);
            if(id.equals(idcard)){
                jsonObject.put("sameViolation",datum);
            }
        }
        if(ids.contains(idcard)){
            System.out.println("同车违章");
        }
        } catch (Exception e) {
            logger.error("查询同车违章出现异常:",e.getMessage());
        }
        return jsonObject;
    }

    @Override
    protected JSONObject analysisSameInet(List<List<CollDatas>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSameRoom(List<List<CollDatas>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSameCase(List<List<CollDatas>> datas) {
        return null;
    }

    @Override
    protected JSONObject analysisSameAccount(List<List<CollDatas>> datas) {
        if (datas.size() == 0) {
            throw new RuntimeException();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sameAccount",null);
        try {
            List<List<CollDatasInner>> kindDatas = getKindDatas(datas, "yunsou", "同户号");
            System.out.print("yunsoux户号"+kindDatas);
            String account1 = kindDatas.get(0).get(0).getData().getData()[0][7];
            String account2 = kindDatas.get(1).get(0).getData().getData()[0][7];
            System.out.println("account1:"+account1);
            System.out.println("account2:"+account2);
            if(account1.equals(account2)){
                jsonObject.put("sameAccount",kindDatas.get(0));
            }
        } catch (Exception e) {
            logger.error("查询同户号出现异常:",e.getMessage());
        }
        return jsonObject;
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
