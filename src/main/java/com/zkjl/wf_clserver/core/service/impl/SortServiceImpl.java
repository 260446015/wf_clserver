package com.zkjl.wf_clserver.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.dto.req.SortPage;
import com.zkjl.wf_clserver.core.exception.CustomerException;
import com.zkjl.wf_clserver.core.service.SortService;
import com.zkjl.wf_clserver.core.util.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SortServiceImpl implements SortService {
    /**
     * sortMsg = 排序内容
     * sortType = 排序规则,1倒叙，2正序
     *
     * @param page
     * @return
     */
    @Override
    public JSONObject sort(SortPage page) throws CustomerException {
        int pageNum = page.getPageNum();
        int pageSize = page.getPageSize();
        String sortMsg = page.getSortMsg();
        Integer sortType = page.getSortType();
        JSONObject data = page.getData();
        Set<List<String>> check = new HashSet<>();
        List<List<String>> dataList = (List<List<String>>) data.get("data");
        dataList.forEach(action ->{
            if(!check.add(action)){
                dataList.remove(action);
            }
        });
        if(page.isPage()){
            if (StringUtils.isBlank(sortMsg)) {//无排序内容，默认只分页
                PageImpl<List<String>> objects = (PageImpl<List<String>>) PageUtil.pageBeagin(dataList.size(), pageNum, pageSize, dataList);
                data.put("data", successPage(objects));
            } else {
                //拿到排序角标
                int index = getSortIndex(data, sortMsg);
                PageImpl<List<List<String>>> objects = getSortData(dataList, index, pageNum, pageSize, sortType);
                data.put("data", successPage(objects));
            }
        }else{
            //拿到排序角标
            int index = getSortIndex(data, sortMsg);
            List<List<String>> sortData = getSortData(dataList, index, sortType);
            data.put("data", sortData);
        }

        return data;
    }

    private PageImpl<List<List<String>>> getSortData(List<List<String>> data, int index, int pageNum, int pageSize, Integer sortType) {
        if (2 == sortType) {//正序
            data.sort(Comparator.comparing(a -> a.get(index)));
        } else {
            data.sort((a, b) -> b.get(index).compareTo(a.get(index)));
        }
        return (PageImpl<List<List<String>>>) PageUtil.pageBeagin(data.size(), pageNum, pageSize, data);

    }
    private List<List<String>> getSortData(List<List<String>> data, int index, Integer sortType) {
        if (2 == sortType) {//正序
            data.sort(Comparator.comparing(a -> a.get(index)));
        } else {
            data.sort((a, b) -> b.get(index).compareTo(a.get(index)));
        }
        return data;

    }


    private int getSortIndex(JSONObject data, String sortMsg) throws CustomerException {
        List<String> columns = (List<String>) data.get("column");
        for (int i = 0; i < columns.size(); i++) {
            String str = columns.get(i);
            if (str.equals(sortMsg)) {
                return i;
            }

        }
        throw new CustomerException("传入数据内无指定的字段名称");
    }

    private JSONObject successPage(PageImpl<?> data){
        JSONObject result = new JSONObject();
        result.put("dataList", data.getContent());
        result.put("totalNumber",data.getTotalElements());
        result.put("totalPage",data.getTotalPages());
        result.put("pageNumber",data.getNumber());
        return result;
    }
}
