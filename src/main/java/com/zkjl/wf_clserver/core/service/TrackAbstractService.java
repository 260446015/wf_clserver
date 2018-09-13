package com.zkjl.wf_clserver.core.service;

import com.google.common.collect.Lists;
import com.zkjl.wf_clserver.core.dto.TrackDto;
import com.zkjl.wf_clserver.core.dto.req.TrackRQ;
import com.zkjl.wf_clserver.core.util.KindDataUtil;
import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

public abstract class TrackAbstractService {

    private static Logger logger = LoggerFactory.getLogger(TrackAbstractService.class);

    @Resource(name = "primaryMongoTemplate")
    private MongoTemplate primaryMongoTemplate;

    protected List<TrackDto> getTrack(HttpServletRequest req, TrackRQ trackRQ) throws Exception {
        List<TrackDto> map = new ArrayList<>();
        List<TrackDto> result = null;
        try {
            List<Document> documents = primaryMongoTemplate.find(new Query(Criteria.where("jobid").is(trackRQ.getJobid())), Document.class, "coll_datas");
            getBgzs(documents, map);
            getSwtjl(documents, map);
            getTljl(documents, map);
            getMhjcg(documents, map);
            getCjsq(documents, map);
            getSdhl(documents, map);
            getThcdc(documents,map);
            result = findFilterList(map, trackRQ);
            result.sort((a, b) -> b.getStayDate().compareTo(a.getStayDate()));
        } catch (Exception e) {

        }
        return result;
    }



    protected void getBgzs(List<Document> documents, List<TrackDto> map) {
        try {
            List<ArrayList> dataList = getTrackData(documents, "sdgayjs", "宾馆住宿");
            List obj = dataList.get(0);
            int bgzsIndex = 0;
            for (int i = 0; i < obj.size(); i++) {
                if (obj.get(i).toString().equals("宾馆名称")) {
                    bgzsIndex = i;
                    break;
                }
            }
            for (int i = 0; i < dataList.get(1).size(); i++) {
                TrackDto trackDto = new TrackDto();
                List datum = (List) dataList.get(1).get(i);
                String stayDate = (String) datum.get(5);
                trackDto.setName("住宿轨迹");
                trackDto.setAddress((String) datum.get(bgzsIndex));
                trackDto.setStayDate(stayDate);
                trackDto.setColumns(obj);
                trackDto.setMark("hotel");
                trackDto.setDataList(datum);
                map.add(trackDto);
            }
        } catch (Exception e) {
            logger.error("住宿轨迹出现异常:", e.getMessage());
        }
    }

    protected void getSwtjl(List<Document> documents, List<TrackDto> map) {
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
                trackDto.setMark("net");
                trackDto.setDataList(datum);
                map.add(trackDto);
            }
        } catch (Exception e) {
            logger.error("网吧轨迹出现异常:", e.getMessage());
        }
    }

    protected void getTljl(List<Document> documents, List<TrackDto> map) {
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
                    trackDto.setMark("train");
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
                    trackDto.setMark("train");
                    trackDto.setDataList(datum);
                    map.add(trackDto);
                }
            }
        } catch (Exception e) {
            logger.error("火车轨迹出现异常:", e.getMessage());
        }
    }

    protected void getMhjcg(List<Document> documents, List<TrackDto> map) {
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
                trackDto.setMark("plane");
                trackDto.setDataList(datum);
                map.add(trackDto);
            }

            List<ArrayList> dataList = getTrackData(documents, "sdgayjs", "新疆民航进出港");
            List obj2 = dataList.get(0);
            for (int i = 0; i < dataList.get(1).size(); i++) {
                TrackDto trackDto = new TrackDto();
                List datum = (List) dataList.get(1).get(i);
                String stayDate = (String) datum.get(10);
                trackDto.setName("飞机轨迹");
                trackDto.setAddress((String) datum.get(9));
                trackDto.setStayDate(stayDate);
                trackDto.setColumns(obj2);
                trackDto.setMark("plane");
                trackDto.setDataList(datum);
                map.add(trackDto);
            }
        } catch (Exception e) {
            logger.error("飞机轨迹出现异常:", e.getMessage());
        }
    }

    protected void getCjsq(List<Document> documents, List<TrackDto> map) {
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
                trackDto.setMark("plane");
                trackDto.setDataList(datum);
                map.add(trackDto);
            }
        } catch (Exception e) {
            logger.error("出入境轨迹出现异常:", e.getMessage());
        }
    }

    protected void getSdhl(List<Document> documents, List<TrackDto> map) {
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
    }

    protected void getThcdc(List<Document> documents, List<TrackDto> map){
        try {
            List<ArrayList> dataList = getTrackData(documents, "yunsou", "铁路同乘车");
            List obj = dataList.get(0);
            for (int i = 0; i < dataList.get(1).size(); i++) {
                TrackDto trackDto = new TrackDto();
                List datum = (List) dataList.get(1).get(i);
                String stayDate = (String) datum.get(2);
                trackDto.setName("铁路同乘车");
                trackDto.setAddress((String) datum.get(6));
                trackDto.setStayDate(stayDate);
                trackDto.setColumns(obj);
                trackDto.setDataList(datum);
                map.add(trackDto);
            }
        } catch (Exception e) {
            logger.error("铁路同乘车出现异常:", e.getMessage());
        }
    }


    private static List<TrackDto> findFilterList(List<TrackDto> list, TrackRQ trackRQ) {
        String startDate = trackRQ.getBeginDate();
        String endDate = trackRQ.getEndDate();
        return list.stream().filter(action -> {
            boolean flag;
            if (StringUtils.isNotBlank(trackRQ.getBeginDate())) {
                flag = action.getStayDate().compareTo(startDate) > 0;
            } else {
                flag = true;
            }
            return flag;
        }).filter(action -> {
            boolean flag;
            if (StringUtils.isNotBlank(trackRQ.getEndDate())) {
                flag = action.getStayDate().compareTo(endDate) < 0;
            } else {
                flag = true;
            }
            return flag;
        }).filter(action -> {
            boolean flag;
            if (StringUtils.isNotBlank(trackRQ.getTrackType())) {
                flag = trackRQ.getTrackType().contains(action.getName());
            } else {
                flag = true;
            }
            return flag;
        }).collect(Collectors.toList());
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

        }
        return result;
    }
}
