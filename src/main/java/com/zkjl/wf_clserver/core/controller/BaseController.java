package com.zkjl.wf_clserver.core.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
	public  String GetCurrentUser(HttpServletRequest req) {
		return (String)req.getSession().getAttribute("CURRENT_USER");
	}
	public  void SetCurrentUser(HttpServletRequest req,String UserName) {
		req.getSession().setAttribute("CURRENT_USER",UserName);
	}
}
