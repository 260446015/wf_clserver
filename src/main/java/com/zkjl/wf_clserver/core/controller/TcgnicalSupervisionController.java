package com.zkjl.wf_clserver.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.service.TcgnicalSupervisionService;
import com.zkjl.wf_clserver.core.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;

/** 图谱查询 */
@Controller
@RequestMapping("/TcgnicalSupervisionController")
public class TcgnicalSupervisionController {
	@Resource
	private TcgnicalSupervisionService service;

	/** 查询 */
	@RequestMapping("/query")
	public String listAll(@RequestParam(value = "Actor[]", required = false) String[] actor,
			@RequestParam(value = "Director[]", required = false) String[] director,
			@RequestParam(value = "Movie[]", required = false) String[] movie,
			@RequestParam(value = "IsComments", required = false) String isComments, HttpServletResponse response) throws Exception {
		// 封装查询条件
		ArrayList<String> list = new ArrayList<String>();
		//此集合顺序决定查询顺序
		if (director != null && director.length > 0) {
			list.add("Director~~~" + Arrays.toString(director));
		}
		if (movie != null && movie.length > 0) {
			list.add("Movie~~~" + Arrays.toString(movie));
		}
		if (actor != null && actor.length > 0) {
			list.add("Actor~~~" + Arrays.toString(actor));
		}
		JSONObject result = service.find(list, isComments);
		ResponseUtil.write(response, result);
		return null;
	}

	/** 初始化下拉框 */
	@RequestMapping("/select")
	public String selectAll(HttpServletResponse response) throws Exception {
		JSONObject result = service.findLables();
		ResponseUtil.write(response, result);
		return null;
	}
}
