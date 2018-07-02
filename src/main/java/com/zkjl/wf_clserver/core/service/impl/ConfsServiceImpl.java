package com.zkjl.wf_clserver.core.service.impl;

import com.zkjl.wf_clserver.core.entity.Confs;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.repository.plover.ConfsRepository;
import com.zkjl.wf_clserver.core.service.ConfsService;
import com.zkjl.wf_clserver.core.util.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("confsService")
public class ConfsServiceImpl implements ConfsService {

    @Autowired
    private ConfsRepository confsRepository;

    /**
     * 添加平台
     */
    @Override
    public boolean addConfsOrUpdate(Confs confs){
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        try {
            confs.setSystemuser(user.getName());
            confs.setCreateDate(new Date());
            confsRepository.save(confs);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Override
    public Optional<Confs> get(String id){
        return confsRepository.findById(id);
    }

    /**
     * 删除平台
     */
    @Override
    public void deleteConfs(String id){
        confsRepository.deleteById(id);
    }

    /**
     * 查找平台
     */
    @Override
    public PageImpl<Confs> findConfs(Integer pageSize, Integer pageNum, String searchStr){
        List<Confs> all = confsRepository.findAll();
        int totalCount;
        all = all.stream().sorted((a, b) -> b.getCreateDate().compareTo(a.getCreateDate())).collect(Collectors.toList());
        if (!StringUtils.isBlank(searchStr)) {
            all = all.stream().filter(confs -> confs.toString().contains(searchStr)).collect(Collectors.toList());
        }
        totalCount = all.size();
        return (PageImpl<Confs>) PageUtil.pageBeagin(totalCount, pageNum, pageSize, all);
    }
}
