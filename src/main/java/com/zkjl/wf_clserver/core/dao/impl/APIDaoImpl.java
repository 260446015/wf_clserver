package com.zkjl.wf_clserver.core.dao.impl;

import com.zkjl.wf_clserver.core.dao.APIDao;
import com.zkjl.wf_clserver.core.entity.JobBean;
import com.zkjl.wf_clserver.core.entity.ResourceBean;
import com.zkjl.wf_clserver.core.exception.CustomerException;
import com.zkjl.wf_clserver.core.exception.ExceptionCode;
import org.bson.Document;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Repository
public class APIDaoImpl implements APIDao {

	@Resource(name = "primaryMongoTemplate")
	private MongoTemplate primaryMongoTemplate;
	@Resource(name = "secondaryMongoTemplate")
	private MongoTemplate secondaryMongoTemplate;

	private final String COLL_DATAS = "coll_datas";
	private final String COLL_USERS = "coll_users";
	private final String COLL_JOBS = "coll_jobs";
	private final String COLL_CONFS = "coll_confs";


	/*
	 * 
	 * (non-Javadoc)
	 * @see com.zkjl.plover.web.dao.APIDao#saveJob(com.zkjl.plover.web.bean.JobBean)
	 */
	@Override
	public boolean saveJob(JobBean jobBean) throws Exception {
		try {
			secondaryMongoTemplate.insert(jobBean, COLL_JOBS);
			return true;
		} catch (Exception e) {
			throw new CustomerException(ExceptionCode.EX_BUS);
		}
	}

	/*
	 * 
	 * (non-Javadoc)
	 * @see com.zkjl.plover.web.dao.APIDao#cacheQuery(java.lang.String)
	 */
	@Override
	public JobBean cacheQuery(String hash) throws Exception {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("hash").is(hash)).with(Sort.by(Direction.DESC,"exetime"));
			return secondaryMongoTemplate.findOne(query, JobBean.class, COLL_JOBS);
		} catch (Exception e) {
			throw new CustomerException(ExceptionCode.EX_BUS);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.zkjl.plover.web.dao.APIDao#retrieveData(java.lang.String, java.lang.String, long)
	 */
	@Override
	public Document retrieveData(String jobid, String resid, long version) throws Exception {
		try {
			return secondaryMongoTemplate.findOne(new Query(Criteria.where("jobid").is(jobid).and("resid").is(resid).and("exetime").gt(version)).with(new Sort(Direction.DESC, "exetime")), Document.class, COLL_DATAS);
		} catch (Exception e) {
			throw new CustomerException(ExceptionCode.EX_BUS);
		}
	}


	/*
	 * (non-Javadoc)
	 * @see com.zkjl.plover.web.dao.APIDao#userConf(java.lang.String)
	 */
	@Override
	public List<ResourceBean> userConf(String username) throws Exception {
		try {
			List<Document> docList = primaryMongoTemplate.find(new Query(Criteria.where("systemuser").is(username)), Document.class, COLL_CONFS);
			List<ResourceBean> resultList = new ArrayList<ResourceBean>();
			for (Document doc : docList) {
				ResourceBean resourceBean = new ResourceBean();
				resourceBean.setId(doc.getString("id"));
				resourceBean.setUsername(doc.getString("username"));
				resourceBean.setPassword(doc.getString("password"));
				resultList.add(resourceBean);
			}
			return resultList;
		} catch (Exception e) {
			throw new CustomerException(ExceptionCode.EX_BUS);
		}
	}


	/*
	 * (non-Javadoc)
	 * @see com.zkjl.plover.web.dao.APIDao#saveMaterial(org.bson.Document)
	 */
	@Override
	public boolean saveMaterial(Document doc) throws Exception {
		try {
			secondaryMongoTemplate.insert(doc, COLL_DATAS);
			return true;
		} catch (Exception e) {
			throw new CustomerException(ExceptionCode.EX_BUS);
		}
	}

	

}
