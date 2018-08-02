package com.zkjl.wf_clserver.core.service;


import com.zkjl.wf_clserver.core.entity.Log;
import com.zkjl.wf_clserver.core.entity.SysUser;
import org.springframework.data.domain.PageImpl;

import java.util.Date;
import java.util.List;

public interface LogService {
 /**
  * 查找日志
  */
 PageImpl<Log> findPage(Integer pageSize, Integer pageNum, String username, Date beginDate, Date endDate);

 void deleteLog(String id);

 List<String> getUserSearchTrack(SysUser sysUser);
}
