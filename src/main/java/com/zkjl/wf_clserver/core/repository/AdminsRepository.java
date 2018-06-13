package com.zkjl.wf_clserver.core.repository;

import com.zkjl.wf_clserver.core.entity.Admins;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author ydw
 * Created on 2018/6/13
 */
public interface AdminsRepository extends PagingAndSortingRepository<Admins,String>,MongoRepository<Admins,String> {

    List<Admins> findByUsername(String username);
}
