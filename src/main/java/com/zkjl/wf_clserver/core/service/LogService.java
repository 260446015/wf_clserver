package com.zkjl.wf_clserver.core.service;


import com.zkjl.wf_clserver.core.entity.Log;
import org.springframework.data.domain.PageImpl;

import java.util.Date;

public interface LogService {
 public void createLog(Log log);
 /**
  * 查找日志
  */
 PageImpl<Log> findPage(Integer pageSize, Integer pageNum, String username, Date beginDate, Date endDate);

 public void deleteLog(String id);
}
