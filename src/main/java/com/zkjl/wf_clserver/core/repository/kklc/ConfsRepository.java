package com.zkjl.wf_clserver.core.repository.kklc;

import com.zkjl.wf_clserver.core.entity.Confs;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ydw
 * Created on 2018/6/23
 */
public interface ConfsRepository extends MongoRepository<Confs,String> {
}
