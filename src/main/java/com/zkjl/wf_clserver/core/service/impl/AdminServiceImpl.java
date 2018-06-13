package com.zkjl.wf_clserver.core.service.impl;

import com.zkjl.wf_clserver.core.entity.Admins;
import com.zkjl.wf_clserver.core.repository.AdminsRepository;
import com.zkjl.wf_clserver.core.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ydw
 * Created on 2018/6/13
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminsRepository adminsRepository;
    @Override
    public List<Admins> find() {
        List<Admins> all = adminsRepository.findAll();
        return all;
    }
}
