package com.zkjl.wf_clserver.core.service;

import com.zkjl.wf_clserver.core.entity.Link;

import java.util.List;

public interface LinkService {

     List<Link> findAll();

    boolean saveOrUpdate(Link link);

     boolean delete(String id);
}
