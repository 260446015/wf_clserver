package com.zkjl.wf_clserver.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.domain.PageImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BaseController {
    /**
     * 获取当前登录用户
     * @return
     */
    public SysUser getCurrentUser(){
        Object principal = SecurityUtils.getSubject().getPrincipal();
        return (SysUser)principal;
    }


    /**
     * 设置当前登录用户
     * @param request
     * @return
     */
    public void setCurrentUser(HttpServletRequest request,SysUser userBean){
        request.getSession().setAttribute("CURRENT_USER", userBean);
    }

    /**
     * 获取客户端IP
     * @param request
     * @return
     */
    public String getClientIP(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    protected ApiResult success(Object obj){
        return new ApiResult().setData(obj).setCode(0).setMessage("消息返回成功");
    }

    protected ApiResult error(String message){
        return new ApiResult().setMessage(message).setCode(-1);
    }

    protected ApiResult successPages(PageImpl<?> data){
        JSONObject result = new JSONObject();
        result.put("dataList", data.getContent());
        result.put("totalNumber",data.getTotalElements());
        result.put("totalPage",data.getTotalPages());
        result.put("pageNumber",data.getNumber());
        return new ApiResult().setData(result).setCode(0).setMessage("消息返回成功");
    }
}
