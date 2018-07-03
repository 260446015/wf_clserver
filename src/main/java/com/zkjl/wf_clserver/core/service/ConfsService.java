package com.zkjl.wf_clserver.core.service;

import com.zkjl.wf_clserver.core.entity.Confs;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.Optional;

public interface ConfsService {
    /**
     * 添加平台
     */
    boolean addConfsOrUpdate(Confs confs);

    /**
     * 删除平台
     */
    public void deleteConfs(String id);

    /**
     * 查找平台
     */
    PageImpl<Confs> findConfs(Integer pageSize, Integer pageNum, String searchStr);

    List<Confs> findAll();

    public Optional<Confs> get(String id);
}
