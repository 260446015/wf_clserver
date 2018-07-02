package com.zkjl.wf_clserver.core.repository.plover;

import com.zkjl.wf_clserver.core.entity.CollDatas;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author ydw
 * Created on 2018/6/28
 */
public interface CollDatasRepository extends MongoRepository<CollDatas,String>{
    List<CollDatas> findByJobid(String jobid);
}
