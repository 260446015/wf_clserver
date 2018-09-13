package com.zkjl.wf_clserver.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.dto.TrackDto;
import com.zkjl.wf_clserver.core.dto.req.SortPage;
import com.zkjl.wf_clserver.core.dto.req.TrackRQ;
import com.zkjl.wf_clserver.core.service.SortService;
import com.zkjl.wf_clserver.core.service.TrackService;
import com.zkjl.wf_clserver.core.util.KindDataUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 轨迹查询
 */
@Controller
@RequestMapping("/api/track")
public class TrackController extends BaseController {

    @Resource(name = "primaryMongoTemplate")
    private MongoTemplate primaryMongoTemplate;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(TrackController.class);

    @Resource
    private SortService sortService;

    @Resource
    private TrackService trackService;

    /**
     * 轨迹查询
     */
    @RequestMapping("/get")
    @ApiOperation(value = "轨迹信息", httpMethod = "GET")
    @ResponseBody
    public List<TrackDto> get(HttpServletRequest req, TrackRQ trackRQ) throws Exception {

		/*
		//查询乘坐客车记录
		mapList.put("busList", null);
		//查询人像轨迹记录
		mapList.put("portraitList", null);
		//查询628轨迹信息
		mapList.put("trajectory", null);*/


        return trackService.getTrack(req, trackRQ);
    }









    /**
     * 针对不同的数据内容进行相关字段的排序并分页显示，如果没有则只进行分页1倒叙2正序
     */
    @PostMapping(value = "sort")
    @ApiOperation(value = "排序并分页", httpMethod = "POST")
    @ResponseBody
    public ApiResult sort(@RequestBody SortPage page) {
        JSONObject jsonObject = null;
        try {
            jsonObject = sortService.sort(page);
        } catch (Exception e) {
            return error(e.getMessage());
        }
        return success(jsonObject);
    }

}
