package com.zkjl.wf_clserver.core.dao;

import com.zkjl.wf_clserver.core.entity.JobBean;
import com.zkjl.wf_clserver.core.entity.PageBean;
import com.zkjl.wf_clserver.core.entity.ResourceBean;
import org.bson.Document;

import java.util.List;


/**
 * 
 * API数据库操作
 * 
 * <li>用户操作</li>
 * <li>采集数据操作</li>
 * <li>日志操作</li>
 * <li>配置操作</li>
 * 
 * @author Jason.zhang
 * @mobile 18282600855
 *
 */
public interface APIDao {
	

	/**
	 * 获取用户资源配置
	 * @param username
	 * @return
	 * @throws Exception
	 */
	List<ResourceBean> userConf(String username) throws Exception;
	

	/**
	 * 保存查询记录
	 * @param jobBean
	 * @return
	 * @throws Exception
	 */
	boolean saveJob(JobBean jobBean) throws Exception;

	/**
	 * 查询是否存在缓存，使用缓存数据
	 * @param hash
	 * @return
	 * @throws Exception
	 */
	JobBean cacheQuery(String hash) throws Exception;

	/**
	 * 页面JS轮训获取采集到的数据，jobid字段一定要设置为索引
	 * @param jobid
	 * @param resid
	 * @param version
	 * @return
	 * @throws Exception
	 */
	Document retrieveData(String jobid, String resid, long version) throws Exception;

	/**
	 * 保存采集器上传的数据
	 * @param doc
	 * @return
	 * @throws Exception
	 */
	boolean saveMaterial(Document doc) throws Exception;

	

	
	
	
}
