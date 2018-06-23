package com.zkjl.wf_clserver.core.repository.kklc;

import com.zkjl.wf_clserver.core.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ydw
 * Created on 2018/6/23
 */
public interface UserOperationRepository extends MongoRepository<Log,String> {
}
