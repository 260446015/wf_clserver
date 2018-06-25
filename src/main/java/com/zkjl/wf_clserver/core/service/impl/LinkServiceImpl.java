package com.zkjl.wf_clserver.core.service.impl;

import com.zkjl.wf_clserver.core.entity.Link;
import com.zkjl.wf_clserver.core.repository.kklc.LinkRepository;
import com.zkjl.wf_clserver.core.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Override
    public List<Link> findAll() {
        return linkRepository.findAll();
    }
    @Override
    public boolean saveOrUpdate(Link link) {
        try {
            link.setCreateDate(new Date());
            linkRepository.save(link);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Override
    public void delete(String id) {
        linkRepository.deleteById(id);
    }
}
