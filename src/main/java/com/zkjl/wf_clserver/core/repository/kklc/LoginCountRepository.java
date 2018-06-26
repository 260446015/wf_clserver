package com.zkjl.wf_clserver.core.repository.kklc;

import com.zkjl.wf_clserver.core.entity.LoginCount;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ydw
 * Created on 2018/6/24
 */
public interface LoginCountRepository extends MongoRepository<LoginCount,String>{
}
