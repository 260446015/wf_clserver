package com.zkjl.wf_clserver.core.controller;

import com.google.common.collect.Lists;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.dto.TrackDto;
import com.zkjl.wf_clserver.core.dto.req.TrackRQ;
import com.zkjl.wf_clserver.core.util.KindDataUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
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
public class TrackController {

    @Resource(name = "secondaryMongoTemplate")
    private MongoTemplate secondMongoTemplate;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(TrackController.class);

    /**
     * 轨迹查询
     */
    @RequestMapping("/get")
    @SystemControllerLog(description = "人员档案-轨迹信息-时间轴展示")
    @ApiOperation(value = "轨迹信息", httpMethod = "GET")
    @ResponseBody
    public List<TrackDto> get(HttpServletRequest req, TrackRQ trackRQ) throws Exception {
        List<TrackDto> map = new ArrayList<>();
        try {
            List<Document> documents = secondMongoTemplate.find(new Query(Criteria.where("jobid").is(trackRQ.getJobid())), Document.class, "coll_datas");
            try {
                List<ArrayList> dataList = getTrackData(documents, "sdgayjs", "宾馆住宿");
                List obj=dataList.get(0);
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
                List obj=result.get(0);
                List<ArrayList> resultList=result.get(1);
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
                List obj=data3List.get(0);
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
            } catch (Exception e) {
                logger.error("火车轨迹出现异常:", e.getMessage());
            }
            try {
                List<ArrayList> data4List = getTrackData(documents, "sdgayjs", "民航进出港");
                List obj=data4List.get(0);
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
                List obj=dataList.get(0);
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
                List obj=data5List.get(0);
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
                List obj=data6List.get(0);
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
                if(flag){
                    if (StringUtils.isNotBlank(trackRQ.getTrackType())) {
                        flag = trackRQ.getTrackType().contains(action.getName());
                    }
                }
            }else{
                if (StringUtils.isNotBlank(trackRQ.getTrackType())) {
                    flag = trackRQ.getTrackType().contains(action.getName());
                }
            }
            return flag;
        }).collect(Collectors.toList());
    }

    private static void ListSort(List<TrackDto> list) {
        list.sort(Comparator.comparing(TrackDto::getStayDate));
    }


    private static List<ArrayList> getTrackData(List<Document> documents, String platKind, String label) {
        List<ArrayList> result = Lists.newArrayList();
        try {
            List<Document> staykindDatas = KindDataUtil.getKindData(documents, platKind, label);
            Map data1 = (Map) staykindDatas.get(0).get("data");
            ArrayList columns= (ArrayList) data1.get("column");
            ArrayList datas = (ArrayList) data1.get("data");
            result.add(columns);
            result.add(datas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
