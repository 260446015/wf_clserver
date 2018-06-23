package com.zkjl.wf_clserver.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理页面跳转
 * @author Jason.zhang
 * @mobile 18282600855
 * @since 2017/10/10
 *
 */
@Controller
public class PageController {
	
	@RequestMapping("/login")
	public ModelAndView login(){
		return new ModelAndView("login");
	}

	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	
	@RequestMapping("/main")
	public String main(ModelAndView modelAndView){
		return 	"/page/main";
	}
	
	@RequestMapping("/users")
	public ModelAndView users(HttpServletRequest request){
		return new ModelAndView("users");
	}
	
	@RequestMapping("/confs")
	public ModelAndView confs(HttpServletRequest request){
		return new ModelAndView("confs");
	}
	
	@RequestMapping("/logs")
	public ModelAndView logs(HttpServletRequest request){
		return new ModelAndView("logs");
	}


}
