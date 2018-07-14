package com.zkjl.wf_clserver.core.service.impl;

import com.zkjl.wf_clserver.core.entity.Link;
import com.zkjl.wf_clserver.core.repository.kklc.LinkRepository;
import com.zkjl.wf_clserver.core.service.LinkService;
import com.zkjl.wf_clserver.core.util.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository linkRepository;
    private static Logger logger = LoggerFactory.getLogger(LinkServiceImpl.class);


    @Override
    public PageImpl<Link> findAll(String search, Integer pageNum, Integer pageSize) {
        List<Link> result;
        if (StringUtils.isBlank(search)) {
            result = linkRepository.findAll(new Sort(Sort.Direction.DESC, "hotCount", "createDate"));
        }else{
            result = linkRepository.findByName(search);
        }
        return (PageImpl<Link>) PageUtil.pageBeagin(result.size(),pageNum,pageSize,result);
    }

    @Override
    public Link saveOrUpdate(Link link) {
        try {
            link.setCreateDate(new Date());
            return linkRepository.save(link);
        } catch (Exception e) {
            logger.error("保存超链接出错",e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(String ids) {
        boolean flag = false;
        try {
            String[] idArr = ids.split(",");
//            String basePath
            Iterable<Link> allById = linkRepository.findAllById(Arrays.asList(idArr));
            linkRepository.deleteAll(allById);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
