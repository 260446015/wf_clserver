package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.ApiResult;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    protected String GetCurrentUser(HttpServletRequest req) {
        return (String) req.getSession().getAttribute("CURRENT_USER");
    }

    protected void SetCurrentUser(HttpServletRequest req, String UserName) {
        req.getSession().setAttribute("CURRENT_USER", UserName);
    }

    protected ApiResult success(Object obj){
        return new ApiResult().setData(obj).setCode(0).setMessage("消息返回成功");
    }

    protected ApiResult error(String message){
        return new ApiResult().setMessage(message).setCode(-1);
    }


}
