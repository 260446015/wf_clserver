package com.zkjl.wf_clserver.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.dto.TrackDto;
import com.zkjl.wf_clserver.core.dto.req.SortPage;
import com.zkjl.wf_clserver.core.dto.req.TrackRQ;
import com.zkjl.wf_clserver.core.service.SortService;
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
 *
 */
@Controller
@RequestMapping("/api/track")
public class TrackController extends BaseController {

    @Resource(name = "primaryMongoTemplate")
    private MongoTemplate primaryMongoTemplate;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(TrackController.class);

    @Resource
    private SortService sortService;

    /**
     * 轨迹查询
     */
    @RequestMapping("/get")
    @ApiOperation(value = "轨迹信息", httpMethod = "GET")
    @ResponseBody
    public List<TrackDto> get(HttpServletRequest req, TrackRQ trackRQ) throws Exception {
        List<TrackDto> map = new ArrayList<>();
        try {
            List<Document> documents = primaryMongoTemplate.find(new Query(Criteria.where("jobid").is(trackRQ.getJobid())), Document.class, "coll_datas");
            try {
                List<ArrayList> dataList = getTrackData(documents, "sdgayjs", "宾馆住宿");
                List obj = dataList.get(0);
                for (int i = 0; i < dataList.get(1).size(); i++) {
                    TrackDto trackDto = new TrackDto();
                    List datum = (List) dataList.get(1).get(i);
                    String stayDate = (String) datum.get(5);
                    trackDto.setName("住宿轨迹");
                    trackDto.setAddress((String) datum.get(15));
                    trackDto.setStayDate(stayDate);
                    trackDto.setColumns(obj);
                    trackDto.setDataList(datum);
                    map.add(trackDto);
                }
            } catch (Exception e) {
                logger.error("住宿轨迹出现异常:", e.getMessage());
            }

            try {
                List<ArrayList> result = getTrackData(documents, "sdgayjs", "山东警务云上网同记录");
                List obj = result.get(0);
                List<ArrayList> resultList = result.get(1);
                List<ArrayList> data2List = new ArrayList<>();
                Set<String> unique = new HashSet<>();
                resultList.stream().forEach(action -> {
                    String hashStr = action.get(1).toString() + action.get(2).toString();
                    if (unique.add(hashStr)) {
                        data2List.add(action);
                    }
                });
                for (int i = 0; i < data2List.size(); i++) {
                    TrackDto trackDto = new TrackDto();
                    List datum = data2List.get(i);
                    String stayDate = (String) datum.get(2);
                    trackDto.setName("网吧轨迹");
                    trackDto.setAddress((String) datum.get(3));
                    trackDto.setStayDate(stayDate);
                    trackDto.setColumns(obj);
                    trackDto.setDataList(datum);
                    map.add(trackDto);
                }
            } catch (Exception e) {
                logger.error("网吧轨迹出现异常:", e.getMessage());
            }
            try {
                List<ArrayList> data3List = getTrackData(documents, "sdgayjs", "铁路记录");
                if (data3List.size() != 0) {
                    List obj = data3List.get(0);
                    for (int i = 0; i < data3List.get(1).size(); i++) {
                        TrackDto trackDto = new TrackDto();
                        List datum = (List) data3List.get(1).get(i);
                        String stayDate = (String) datum.get(11);
                        trackDto.setName("火车轨迹");
                        trackDto.setAddress((String) datum.get(19));
                        trackDto.setStayDate(stayDate);
                        trackDto.setColumns(obj);
                        trackDto.setDataList(datum);
                        map.add(trackDto);
                    }
                }

                List<ArrayList> data3List2 = getTrackData(documents, "sdgayjs", "公安请求服务火车购票记录");
                if (data3List2.size() != 0) {
                    List obj2 = data3List2.get(0);
                    for (int i = 0; i < data3List2.get(1).size(); i++) {
                        TrackDto trackDto = new TrackDto();
                        List datum = (List) data3List2.get(1).get(i);
                        System.out.println(datum);
                        String stayDate = (String) datum.get(0);
                        trackDto.setName("火车轨迹");
                        trackDto.setAddress((String) datum.get(3));
                        trackDto.setStayDate(stayDate);
                        trackDto.setColumns(obj2);
                        trackDto.setDataList(datum);
                        map.add(trackDto);
                    }
                }
            } catch (Exception e) {
                logger.error("火车轨迹出现异常:", e.getMessage());
            }
            try {
                List<ArrayList> data4List = getTrackData(documents, "sdgayjs", "民航进出港");
                List obj = data4List.get(0);
                for (int i = 0; i < data4List.get(1).size(); i++) {
                    TrackDto trackDto = new TrackDto();
                    List datum = (List) data4List.get(1).get(i);
                    String stayDate = (String) datum.get(8);
                    trackDto.setName("飞机轨迹");
                    trackDto.setAddress((String) datum.get(6));
                    trackDto.setStayDate(stayDate);
                    trackDto.setColumns(obj);
                    trackDto.setDataList(datum);
                    map.add(trackDto);
                }
            } catch (Exception e) {
                logger.error("飞机轨迹出现异常:", e.getMessage());
            }

            try {
                List<ArrayList> dataList = getTrackData(documents, "sdgayjs", "新疆民航进出港");
                List obj = dataList.get(0);
                for (int i = 0; i < dataList.get(1).size(); i++) {
                    TrackDto trackDto = new TrackDto();
                    List datum = (List) dataList.get(1).get(i);
                    String stayDate = (String) datum.get(10);
                    trackDto.setName("飞机轨迹");
                    trackDto.setAddress((String) datum.get(9));
                    trackDto.setStayDate(stayDate);
                    trackDto.setColumns(obj);
                    trackDto.setDataList(datum);
                    map.add(trackDto);
                }
            } catch (Exception e) {
                logger.error("飞机轨迹出现异常:", e.getMessage());
            }

            try {
                List<ArrayList> data5List = getTrackData(documents, "sdgayjs", "出境申请");
                List obj = data5List.get(0);
                for (int i = 0; i < data5List.get(1).size(); i++) {
                    TrackDto trackDto = new TrackDto();
                    List datum = (List) data5List.get(1).get(i);
                    String stayDate = (String) datum.get(18);
                    trackDto.setName("出入境轨迹");
                    trackDto.setAddress((String) datum.get(5));
                    trackDto.setStayDate(stayDate);
                    trackDto.setColumns(obj);
                    trackDto.setDataList(datum);
                    map.add(trackDto);
                }
            } catch (Exception e) {
                logger.error("出入境轨迹出现异常:", e.getMessage());
            }

            try {
                List<ArrayList> data6List = getTrackData(documents, "sdgayjs", "山东核录");
                List obj = data6List.get(0);
                for (int i = 0; i < data6List.get(1).size(); i++) {
                    TrackDto trackDto = new TrackDto();
                    List datum = (List) data6List.get(1).get(i);
                    String stayDate = (String) datum.get(2);
                    trackDto.setName("核录轨迹");
                    trackDto.setAddress((String) datum.get(5));
                    trackDto.setStayDate(stayDate);
                    trackDto.setColumns(obj);
                    trackDto.setDataList(datum);
                    map.add(trackDto);
                }
            } catch (Exception e) {
                logger.error("核录轨迹出现异常:", e.getMessage());
            }
		/*
		//查询乘坐客车记录
		mapList.put("busList", null);
		//查询人像轨迹记录
		mapList.put("portraitList", null);
		//查询628轨迹信息
		mapList.put("trajectory", null);*/
        } catch (Exception e) {
            logger.error("出现异常:", e.getMessage());
        }
        List<TrackDto> result = findFilterList(map, trackRQ);
        ListSort(result);
        return result;
    }


    private static List<TrackDto> findFilterList(List<TrackDto> list, TrackRQ trackRQ) {
        List<TrackDto> trackList = Lists.newArrayList();
        String startDate = trackRQ.getBeginDate();
        String endDate = trackRQ.getEndDate();
        return list.stream().filter(action -> {
            boolean flag = true;
            if (StringUtils.isNotBlank(trackRQ.getBeginDate()) && StringUtils.isNotBlank(trackRQ.getEndDate())) {
                flag = action.getStayDate().compareTo(startDate) > 0 &&
                        action.getStayDate().compareTo(endDate) < 0;
                if (flag) {
                    if (StringUtils.isNotBlank(trackRQ.getTrackType())) {
                        flag = trackRQ.getTrackType().contains(action.getName());
                    }
                }
            } else {
                if (StringUtils.isNotBlank(trackRQ.getTrackType())) {
                    flag = trackRQ.getTrackType().contains(action.getName());
                }
            }
            return flag;
        }).collect(Collectors.toList());
    }

    private static void ListSort(List<TrackDto> list) {
        list.sort((a, b) -> b.getStayDate().compareTo(a.getStayDate()));
    }


    private static List<ArrayList> getTrackData(List<Document> documents, String platKind, String label) {
        List<ArrayList> result = Lists.newArrayList();
        try {
            List<Document> staykindDatas = KindDataUtil.getKindData(documents, platKind, label);
            Map data1 = (Map) staykindDatas.get(0).get("data");
            ArrayList columns = (ArrayList) data1.get("column");
            ArrayList datas = (ArrayList) data1.get("data");
            result.add(columns);
            result.add(datas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
