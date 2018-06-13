package com.zkjl.wf_clserver.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.entity.PageBean;
import com.zkjl.wf_clserver.core.entity.User;
import com.zkjl.wf_clserver.core.service.UserService;
import com.zkjl.wf_clserver.core.util.MD5Util;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/** 用户操作 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Resource
	private UserService userService;
	private static final Logger log = Logger.getLogger(UserController.class);// 日志文件

	/**
	 * 登录
	 */
	@RequestMapping("/login")
	@SystemControllerLog(description="登陆系统")
	public @ResponseBody
	ApiResult<Document> login(User user, HttpServletRequest request) {
		ApiResult<Document> apiResult=new ApiResult<>();
		Subject currentUser = SecurityUtils.getSubject();
		try {
	            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
	            token.setRememberMe(true);
	           
	        	// 执行登录. 
	            currentUser.login(token);
	            this.SetCurrentUser(request, user.getUserName());
	            Document document=userService.login(user.getUserName(),user.getPassword());
	            apiResult.setData(document);
	            return apiResult;
		} catch (UnknownAccountException uae) {
			System.out.println("账号不存在！"+uae.getMessage());
	    } catch (IncorrectCredentialsException ice) {
	    	System.out.println("密码不正确！"+ice.getMessage());
	    } catch (AuthenticationException ae) {
	    	System.out.println("用户名或者密码错误！"+ae.getMessage());
	    } catch (UnknownSessionException ue) {
	    	System.out.println("登录session失效！"+ue.getMessage());
	          
	    }  
		return apiResult.error("用户名或密码错误！");
	}

	/**
	 * 修改密码
	 */
	@RequestMapping("/modifyPassword")
	@SystemControllerLog(description="后台管理-修改资料")
	@ResponseBody
	public ApiResult<?> modifyPassword(User user, HttpServletResponse response) throws Exception {
		ApiResult<?> apiResult=new ApiResult<>();
		String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
		String MD5NewPwd = MD5Util.MD5Encode(user.getNewPassword(), "UTF-8");
		user.setPassword(MD5pwd);
		user.setNewPassword(MD5NewPwd);

		Document login = userService.login(user.getUserName(),user.getPassword());
		JSONObject result = new JSONObject();
		if (null != login) {
			user.setPassword(MD5NewPwd);
			int resultTotal = userService.updateUser(user);
			if (resultTotal > 0) {
				result.put("success", true);
			} else {
				result.put("success", false);
			}
		} else {
			result.put("success", false);
		}
		log.info("request: user/modifyPassword , user: " + user.toString());
		return apiResult;
	}

	/**
	 * 退出系统
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	@SystemControllerLog(description="退出系统")
	public @ResponseBody ApiResult<?> logout(HttpSession session) throws Exception {
		ApiResult<?> apiResult=new ApiResult<>();
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout();
			return apiResult;
		}
		return apiResult.error("退出失败！");
	}

	/**
	 * 查询
	 */
	@RequestMapping("/list")
	@SystemControllerLog(description="后台管理-用户列表查询")
	@ResponseBody
	public Map<String, Object> list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, User s_user, HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", s_user.getName());
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map = userService.findUser(s_user.getName(),pageBean.getStart(),pageBean.getPageSize());	
		return map;
	}

	/**
	 * 管理员添加或修改
	 */
	@RequestMapping("/save")
	@SystemControllerLog(description="后台管理-用户添加")
	@ResponseBody
	public ApiResult<?> save(User user, HttpServletResponse response) throws Exception {
		ApiResult<?> apiResult=new ApiResult<>();
		if (user.getId() == null) {
			boolean ifExist = userService.ifExist(user.getUserName());
			if (ifExist) {
				return apiResult.error("当前用户名已存在不允许添加！");
			}else{
				userService.addUser(user);
			}
		} 
		return apiResult;
	}

	/**
	 * 管理员删除
	 */
	@RequestMapping("/delete")
	@SystemControllerLog(description="后台管理-用户删除")
	@ResponseBody
	public ApiResult<?> delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
		ApiResult<?> apiResult=new ApiResult<>();
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			userService.deleteUser(idsStr[i]);
		}
		return apiResult;
	}
}
