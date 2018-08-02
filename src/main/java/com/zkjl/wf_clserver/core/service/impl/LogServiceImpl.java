package com.zkjl.wf_clserver.core.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.zkjl.wf_clserver.core.common.Constans;
import com.zkjl.wf_clserver.core.entity.Log;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.service.LogService;
import com.zkjl.wf_clserver.core.util.MongoManager;
import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {
    @Resource(name = "primaryMongoTemplate")
    private MongoTemplate primaryMongoTemplate;


    @Override
    public PageImpl<Log> findPage(Integer pageSize, Integer pageNum, String username, Date beginDate, Date endDate) {
        MongoCollection<Document> conllections = primaryMongoTemplate.getCollection("log");
        BasicDBObject basicDBObject = new BasicDBObject();
        if (StringUtils.isNotBlank(username)) {
            basicDBObject.append("name", username);
        } else if (beginDate != null && endDate != null) {
            basicDBObject.append("createDate", new BasicDBObject("$gte", beginDate).append("$lte", endDate));
        }
        FindIterable<Document> docIte = conllections.find(basicDBObject).sort(new BasicDBObject().append("createDate", -1));
        ;
        Iterator<Document> it = docIte.iterator();
        List<Log> all = new ArrayList<Log>();
        while (it.hasNext()) {
            Document doc = it.next();
            Log log = new Log();
            log.setId(doc.getObjectId("_id").toString());
            log.setName(doc.getString("name"));
            log.setIp(doc.getString("ip"));
            log.setDescription(doc.getString("description"));
            log.setCreateDate(doc.getDate("createDate"));
            log.setArgs(doc.getString("args"));
            all.add(log);
        }
        int totalCont = 0;
        all = all.stream().sorted((a, b) -> b.getCreateDate().compareTo(a.getCreateDate())).collect(Collectors.toList());
        totalCont = all.size();
        all = all.stream().skip(pageNum * pageSize).limit(pageSize).collect(Collectors.toList());
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        PageImpl<Log> logPage = new PageImpl<>(all, pageRequest, totalCont);
        return logPage;
    }

    @Override
    public void deleteLog(String id) {
        MongoCollection<Document> conllections = primaryMongoTemplate.getCollection("log");
        BasicDBObject query = new BasicDBObject();
        ObjectId objid = new ObjectId(id);
        query.put("_id", objid);
        //删除id为1的文档
        conllections.deleteOne(query);
    }

    @Override
    public List<String> getUserSearchTrack(SysUser user) {
        List<Log> logs = primaryMongoTemplate.find(new Query(Criteria.where("name").is(user.getUsername())).with(new Sort(Sort.Direction.DESC, "createDate")), Log.class, Constans.LOG);
        Set<String> checkStr = new HashSet<>();
        List<String> result = new ArrayList<>();
        List<String> datas = logs.stream().filter(action -> action.getDescription().equals("智能搜索")).limit(50).map(Log :: getArgs).collect(Collectors.toList());
        for (int i = 0; i < datas.size(); i++) {
            if(checkStr.add(datas.get(i))){
                result.add(datas.get(i));
            }
            if(result.size() >= 5){
                break;
            }
        }
        return result;
    }
}
