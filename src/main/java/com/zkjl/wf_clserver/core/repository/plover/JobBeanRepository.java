package com.zkjl.wf_clserver.core.repository.plover;

import com.zkjl.wf_clserver.core.entity.JobBean;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ydw
 * Created on 2018/6/27
 */
public interface JobBeanRepository extends MongoRepository<JobBean,String>{
}
