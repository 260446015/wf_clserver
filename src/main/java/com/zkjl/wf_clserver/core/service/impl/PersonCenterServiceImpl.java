package com.zkjl.wf_clserver.core.service.impl;

import com.zkjl.wf_clserver.core.common.Constans;
import com.zkjl.wf_clserver.core.dto.vo.ConfsVO;
import com.zkjl.wf_clserver.core.entity.Confs;
import com.zkjl.wf_clserver.core.exception.CustomerException;
import com.zkjl.wf_clserver.core.repository.kklc.ConfsRepository;
import com.zkjl.wf_clserver.core.service.PersonCenterService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonCenterServiceImpl implements PersonCenterService {

    @Resource
    private ConfsRepository confsRepository;
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<ConfsVO> listSearchConfig(String username) {
        List<Confs> bySystemuser = confsRepository.findBySystemuser(username);
        List<ConfsVO> result = new ArrayList<>();
        bySystemuser.forEach(action -> {
            ConfsVO vo = new ConfsVO();
            BeanUtils.copyProperties(action, vo);
            vo.setIfCertificate();
            result.add(vo);
        });
        return result;
    }

    @Override
    public ConfsVO updateConfs(Confs confs) throws CustomerException {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(confs.getId()).and("systemuser").is(confs.getSystemuser()));
        Confs check = mongoTemplate.findOne(query, Confs.class, Constans.COLLCONFS);
        Confs save;
        if (check == null) {
            save = confsRepository.save(confs);
        } else {
            if (StringUtils.isNotBlank(confs.getUsername())) {
                check.setUsername(confs.getUsername());
            }
            if (StringUtils.isNotBlank(confs.getPassword())) {
                check.setPassword(confs.getPassword());
            }
            save = confsRepository.save(check);
        }
        ConfsVO vo = new ConfsVO();
        BeanUtils.copyProperties(save, vo);
        vo.setIfCertificate();
        return vo;
    }
}
