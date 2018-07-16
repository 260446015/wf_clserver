package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.dto.req.AnalysisRQ;
import com.zkjl.wf_clserver.core.service.ElementAnalysisService;
import com.zkjl.wf_clserver.core.util.KindDataUtil;
import com.zkjl.wf_clserver.core.util.PageUtil;
import io.swagger.annotations.ApiOperation;
import org.bson.Document;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ydw
 * Created on 2018/6/27
 */
@RestController
@RequestMapping(name = "/api/analysis")
public class ElementAnalysisController extends BaseController {

    @Resource
    private ElementAnalysisService elementAnalysisService;
    @Resource(name = "primaryMongoTemplate")
    private MongoTemplate primaryMongoTemplate;

    @Resource(name = "secondaryMongoTemplate")
    private MongoTemplate secondaryMongoTemplate;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ElementAnalysisController.class);

    @GetMapping
    @SystemControllerLog(description="同要素关联分析")
    @ApiOperation(value = "同要素关联分析")
    public ApiResult analysis(String word1, String word2) throws Exception {

        return success(elementAnalysisService.analysis(word1, word2));
    }

    @RequestMapping("/getList")
    @SystemControllerLog(description="同要素列表")
    @ApiOperation(value = "同要素列表", httpMethod = "GET")
    @ResponseBody
    public ApiResult getList(HttpServletRequest req,AnalysisRQ analysisRQ) throws Exception {
        Map<String,Object> map=new HashMap<>();
        PageImpl<Document> result=null;
        try {
            List<Document> documents = secondaryMongoTemplate.find(new Query(Criteria.where("jobid").is(analysisRQ.getJobid())), Document.class, "coll_datas");
            try {
                List<ArrayList> all = KindDataUtil.getTrackData(documents, analysisRQ.getPlatform(), analysisRQ.getDataType());
                int totalCount;
                totalCount = all.get(1).size();
                result= (PageImpl<Document>) PageUtil.pageBeagin(totalCount, analysisRQ.getPageNum(), analysisRQ.getPageSize(), all.get(1));
                map.put("dataList", result.getContent());
                map.put("totalNumber",result.getTotalElements());
                map.put("totalPage",result.getTotalPages());
                map.put("pageNumber",result.getNumber());
                map.put("columns",all.get(0));
            } catch (Exception e) {
                logger.error("数据查询出现异常:", e.getMessage());
            }
        } catch (Exception e) {
            logger.error("未获取到平台数据", e.getMessage());
        }
        return success(map);
    }
}
