package com.zkjl.wf_clserver.core.service;

import com.zkjl.wf_clserver.core.dto.vo.ConfsVO;
import com.zkjl.wf_clserver.core.entity.Confs;
import com.zkjl.wf_clserver.core.exception.CustomerException;

import java.util.List;

public interface PersonCenterService {

    List<ConfsVO> listSearchConfig(String username);

    ConfsVO updateConfs(Confs confs) throws CustomerException;
}
