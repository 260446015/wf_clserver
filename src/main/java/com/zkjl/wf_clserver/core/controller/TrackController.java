package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.dto.TrackDto;
import com.zkjl.wf_clserver.core.dto.req.TrackRQ;
import com.zkjl.wf_clserver.core.util.KindDataUtil;
import io.swagger.annotations.ApiOperation;
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


/** 轨迹查询 */
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
	@SystemControllerLog(description="人员档案-轨迹信息-时间轴展示")
	@ApiOperation(value = "轨迹信息", httpMethod = "GET")
	@ResponseBody
	public List<TrackDto> get(HttpServletRequest req, String jobid) throws Exception {
		List<TrackDto> map=new ArrayList<>();
		try {
		List<Document> documents = secondMongoTemplate.find(new Query(Criteria.where("jobid").is(jobid)), Document.class, "coll_datas");
			try {
		List<Document> staykindDatas = KindDataUtil.getKindData(documents,"sdgayjs", "宾馆住宿");
		Map data1 = (Map) staykindDatas.get(0).get("data");
		List<ArrayList> dataList = (List) data1.get("data");
		for (int i = 0; i < dataList.size(); i++) {
			TrackDto trackDto=new TrackDto();
			List datum = dataList.get(i);
			String stayDate= (String) datum.get(5);
			trackDto.setName("住宿轨迹");
			trackDto.setAddress((String) datum.get(14));
			trackDto.setStayDate(stayDate);
			trackDto.setDataList(datum);
			map.add(trackDto);
		}
		      } catch (Exception e) {
			     logger.error("住宿轨迹出现异常:",e.getMessage());
		      }
			try {
		List<Document> inetkindDatas = KindDataUtil.getKindData(documents,"sdgayjs", "山东警务云上网同记录");
		Map data2 = (Map) inetkindDatas.get(0).get("data");
		List<ArrayList> data2List = (List) data2.get("data");
		for (int i = 0; i < data2List.size(); i++) {
			TrackDto trackDto=new TrackDto();
			List datum = data2List.get(i);
			String stayDate= (String) datum.get(2);
			trackDto.setName("网吧轨迹");
			trackDto.setAddress((String) datum.get(16));//
			trackDto.setStayDate(stayDate);
			trackDto.setDataList(datum);
			map.add(trackDto);
		}
			} catch (Exception e) {
				logger.error("网吧轨迹出现异常:",e.getMessage());
			}
			try {
		List<Document> trainkindDatas = KindDataUtil.getKindData(documents,"sdgayjs", "铁路记录");
		Map data3 = (Map) trainkindDatas.get(0).get("data");
		List<ArrayList> data3List = (List) data3.get("data");
		for (int i = 0; i < data3List.size(); i++) {
			TrackDto trackDto=new TrackDto();
			List datum = data3List.get(i);
			String stayDate= (String) datum.get(11);
			trackDto.setName("火车轨迹");
			trackDto.setAddress((String) datum.get(16));
			trackDto.setStayDate(stayDate);
			trackDto.setDataList(datum);
			map.add(trackDto);
		}
			} catch (Exception e) {
				logger.error("火车轨迹出现异常:",e.getMessage());
			}
			try {
		List<Document> planekindDatas = KindDataUtil.getKindData(documents,"sdgayjs", "民航进出港");
		Map data4 = (Map) planekindDatas.get(0).get("data");
		List<ArrayList> data4List = (List) data4.get("data");
		for (int i = 0; i < data4List.size(); i++) {
			TrackDto trackDto=new TrackDto();
			List datum = data4List.get(i);
			String stayDate= (String) datum.get(8);
			trackDto.setName("飞机轨迹");
			trackDto.setAddress((String) datum.get(6));
			trackDto.setStayDate(stayDate);
			trackDto.setDataList(datum);
			map.add(trackDto);
		}
			} catch (Exception e) {
				logger.error("飞机轨迹出现异常:",e.getMessage());
			}
			try {
		List<Document> entryExitkindDatas = KindDataUtil.getKindData(documents,"sdgayjs", "出境申请");
		Map data5 = (Map) entryExitkindDatas.get(0).get("data");
		List<ArrayList> data5List = (List) data5.get("data");
		for (int i = 0; i < data5List.size(); i++) {
			TrackDto trackDto=new TrackDto();
			List datum = data5List.get(i);
			String stayDate= (String) datum.get(18);
			trackDto.setName("出入境轨迹");
			trackDto.setAddress((String) datum.get(5));//
			trackDto.setStayDate(stayDate);
			trackDto.setDataList(datum);
			map.add(trackDto);
		}
			} catch (Exception e) {
				logger.error("出入境轨迹出现异常:",e.getMessage());
			}

			try {
				List<Document> recordkindDatas = KindDataUtil.getKindData(documents,"sdgayjs", "山东核录");
				Map data6 = (Map) recordkindDatas.get(0).get("data");
				List<ArrayList> data6List = (List) data6.get("data");
				for (int i = 0; i < data6List.size(); i++) {
					TrackDto trackDto=new TrackDto();
					List datum = data6List.get(i);
					String stayDate= (String) datum.get(2);
					trackDto.setName("核录轨迹");
					trackDto.setAddress((String) datum.get(5));
					trackDto.setStayDate(stayDate);
					trackDto.setDataList(datum);
					map.add(trackDto);
				}
			} catch (Exception e) {
				logger.error("核录轨迹出现异常:",e.getMessage());
			}
		ListSort(map);

		/*
		//查询乘坐客车记录
		mapList.put("busList", null);
		//查询人像轨迹记录
		mapList.put("portraitList", null);
		//查询628轨迹信息
		mapList.put("trajectory", null);*/
		} catch (Exception e) {
			logger.error("出现异常:",e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 轨迹查询
	 */
	@RequestMapping("/getTimeAxis")
	@SystemControllerLog(description="人员档案-轨迹信息-时间轴展示")
	@ApiOperation(value = "轨迹信息", httpMethod = "GET")
	public Map<String, Object> getTimeAxis(HttpServletRequest req,TrackRQ trackRQ) throws Exception {
		Map<String, Object> mapList=new HashMap<>();
		//mapList=trackService.findTrackTimeLine(trackRQ);
		return mapList;
	}

	private static void ListSort(List<TrackDto> list) {
		list.sort(Comparator.comparing(TrackDto::getStayDate));
	}


}
