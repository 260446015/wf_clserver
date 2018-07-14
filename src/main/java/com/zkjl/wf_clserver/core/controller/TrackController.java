package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.dto.req.TrackRQ;
import com.zkjl.wf_clserver.core.util.KindDataUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/** 轨迹查询 */
@Controller
@RequestMapping("/track")
public class TrackController {

	@Resource(name = "secondaryMongoTemplate")
	private MongoTemplate secondMongoTemplate;
	
	private static final Logger log = Logger.getLogger(TrackController.class);// 日志文件

	/**
	 * 轨迹查询
	 */
	@RequestMapping("/get")
	@SystemControllerLog(description="人员档案-轨迹信息-分类展示")
	@ApiOperation(value = "轨迹信息", httpMethod = "GET")
	public Map<String, Object> get(HttpServletRequest req,String jobid) throws Exception {
		Map<String, Object> mapList=new HashMap<>();

		List<List<Document>> list = new ArrayList<>(2);
		List<Document> documents = secondMongoTemplate.find(new Query(Criteria.where("jobid").is(jobid)), Document.class, "coll_datas");
		list.add(documents);
		List<List<Document>> qdkindDatas = KindDataUtil.getKindDatas(list,"sdgayjs", "同单位");

		Map data = (Map) qdkindDatas.get(0).get(0).get("data");
		List<ArrayList> dataList = (List) data.get("data");
		for (int i = 0; i < list.size(); i++) {
			List datum = list.get(i);
		}

		/*//查询住宿信息
		Map<String, Object> stayMap=trackService.findStay(idCard,null,null,null);
		mapList.put("stayList", stayMap.get("list"));
		//查询网吧上网记录
		Map<String, Object> internetBarMap=trackService.findInternetBar(idCard,null,null,null);
		mapList.put("internetBarList", internetBarMap.get("list"));
		//查询乘坐火车记录
		Map<String, Object> takeTrainMap=trackService.findTakeTrain(idCard,null,null,null);
		mapList.put("takeTrainList", takeTrainMap.get("list"));
		//查询乘坐飞机记录
		Map<String, Object> takePlaneMap=trackService.findTakePlane(idCard,null,null,null);
		mapList.put("takePlaneList", takePlaneMap.get("list"));
		//查询出入境记录
		Map<String, Object> entryExitMap=trackService.findEntryExit(idCard,null,null,null);
		mapList.put("entryExitList", entryExitMap.get("list"));
		//查询乘坐客车记录
		mapList.put("busList", null);
		//查询人像轨迹记录
		mapList.put("portraitList", null);
		//查询628轨迹信息
		mapList.put("trajectory", null);*/
		return mapList;
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
	
	
}
