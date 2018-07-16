package com.zkjl.wf_clserver.core.repository.kklc;

import com.zkjl.wf_clserver.core.entity.JobBean;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author ydw
 * Created on 2018/6/27
 */
public interface JobBeanRepository extends MongoRepository<JobBean,String>{
    List<JobBean> findByJobid(String jobid);
}
