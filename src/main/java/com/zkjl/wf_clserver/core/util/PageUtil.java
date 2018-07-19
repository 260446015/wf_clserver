package com.zkjl.wf_clserver.core.util;

import com.zkjl.wf_clserver.core.entity.SysUser;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ydw
 * Created on 2018/6/23
 */
public class PageUtil {

    public static PageImpl<?> pageBeagin(int totalCount,int pageNum,int pageSize,List<?> data){
        data = data.stream().skip(pageNum*pageSize).limit(pageSize).collect(Collectors.toList());
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
       return new PageImpl<>(data,pageRequest,totalCount);
    }
}
