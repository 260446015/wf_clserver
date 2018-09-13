package com.zkjl.wf_clserver.core.service.impl;

import com.zkjl.wf_clserver.core.common.Constans;
import com.zkjl.wf_clserver.core.dto.LinkDTO;
import com.zkjl.wf_clserver.core.entity.Link;
import com.zkjl.wf_clserver.core.repository.kklc.LinkRepository;
import com.zkjl.wf_clserver.core.service.LinkService;
import com.zkjl.wf_clserver.core.util.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository linkRepository;
    private static Logger logger = LoggerFactory.getLogger(LinkServiceImpl.class);
    @Resource
    private MongoTemplate mongoTemplate;


    @Override
    public PageImpl<Link> findAll(LinkDTO linkDTO) {
        String name = linkDTO.getName();
        String linkType = linkDTO.getLinkType();
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "hotCount", "createDate"));
        if (StringUtils.isNotBlank(name)) {
            query.addCriteria(Criteria.where("name").regex("^.*" + name + ".*$"));
        }
        if (StringUtils.isNotBlank(linkType)) {
            query.addCriteria(Criteria.where("linkType").is(linkType));
        }
        List<Link> result = mongoTemplate.find(query, Link.class, Constans.LINK);
        return (PageImpl<Link>) PageUtil.pageBeagin(result.size(), linkDTO.getPageNum(), linkDTO.getPageSize(), result);
    }

    @Override
    public Link saveOrUpdate(Link link) {
        try {
            link.setCreateDate(new Date());
            return linkRepository.save(link);
        } catch (Exception e) {
            logger.error("保存超链接出错", e.getMessage());
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
