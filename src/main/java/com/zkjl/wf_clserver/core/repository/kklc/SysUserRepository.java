package com.zkjl.wf_clserver.core.repository.kklc;

import com.zkjl.wf_clserver.core.entity.SysUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author ydw
 * Created on 2018/6/23
 */
public interface SysUserRepository extends MongoRepository<SysUser,String>{
    SysUser findByNameAndPassword(String username, String password);

    SysUser findByName(String username);
}