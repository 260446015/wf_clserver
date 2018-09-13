package com.zkjl.wf_clserver.core.service;

import com.zkjl.wf_clserver.core.dto.LinkDTO;
import com.zkjl.wf_clserver.core.entity.Link;
import org.springframework.data.domain.PageImpl;

public interface LinkService {

    PageImpl<Link> findAll(LinkDTO linkDTO);

    Link saveOrUpdate(Link link);

    boolean delete(String ids);
}
