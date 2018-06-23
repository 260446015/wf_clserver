package com.zkjl.wf_clserver.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.dto.LoginDTO;
import com.zkjl.wf_clserver.core.entity.Admins;
import com.zkjl.wf_clserver.core.entity.PageBean;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.entity.User;
import com.zkjl.wf_clserver.core.service.UserService;
import com.zkjl.wf_clserver.core.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户操作
 */
@RestController
@RequestMapping("/user")
@Api(value = "User-API", description = "这是用户接口详细信息的描述")
public class UserController extends BaseController {

    @Resource
    private UserService userService;
    private static final Logger log = Logger.getLogger(UserController.class);// 日志文件

    /**
     * 登录
     */
    @GetMapping("/login")
    @SystemControllerLog(description = "登陆系统")
    @ApiOperation(value = "用户登录", notes = "根据登录用户的姓名密码进行校验，返回登录数据", httpMethod = "GET")
    public ApiResult login(String username, String password) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject currentUser = SecurityUtils.getSubject();
//            token.setRememberMe(true);
            // 执行登录.
            currentUser.login(token);
            SysUser login = userService.login(username, password);
            return success(login);
        } catch (UnknownAccountException uae) {
            System.out.println("账号不存在！" + uae.getMessage());
        } catch (IncorrectCredentialsException ice) {
            System.out.println("密码不正确！" + ice.getMessage());
        } catch (AuthenticationException ae) {
            System.out.println("用户名或者密码错误！" + ae.getMessage());
        } catch (UnknownSessionException ue) {
            System.out.println("登录session失效！" + ue.getMessage());

        }
        return error("用户名或密码错误！");
    }

    /**
     * 修改密码
     */
    @RequestMapping("/modifyPassword")
    @SystemControllerLog(description = "后台管理-修改资料")
    @ResponseBody
    @ApiOperation(value = "用户密码修改", notes = "根据用户id修改用户信息", httpMethod = "POST")
    public ApiResult modifyPassword(@RequestBody User user, HttpServletResponse response) throws Exception {
//        String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
//        String MD5NewPwd = MD5Util.MD5Encode(user.getNewPassword(), "UTF-8");
//        user.setPassword(MD5pwd);
//        user.setNewPassword(MD5NewPwd);

        SysUser login = userService.login(user.getUserName(), user.getPassword());
        JSONObject result = new JSONObject();
        if (null != login) {
            user.setPassword("");
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
        return success(result);
    }

    /**
     * 退出系统
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/logout")
    @SystemControllerLog(description = "退出系统")
    @ApiOperation(value = "用户退出", httpMethod = "GET")
    public String logout() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            return "logout->success";
        }
        return "logout-error";
    }

    /**
     * 查询
     */
    @GetMapping("/list")
    @SystemControllerLog(description = "后台管理-用户列表查询")
    @ResponseBody
    @ApiOperation(value = "用户列表查询")
    public ApiResult list(Integer pageSize,Integer pageNum,String searchStr) throws Exception {
        PageImpl<SysUser> user;
        try {
            user = userService.findUser(pageSize,pageNum,searchStr);
        } catch (Exception e) {
            return error("查询用户列表失败");
        }
        return successPages(user);
    }

    /**
     * 管理员添加或修改
     */
    @PostMapping("/save")
    @SystemControllerLog(description = "后台管理-用户添加")
    @ResponseBody
    @ApiOperation(value = "用户添加", httpMethod = "POST")
    public ApiResult save(@RequestBody User user) throws Exception {
        if (user.getId() == null) {
            boolean ifExist = userService.ifExist(user.getUserName());
            if (ifExist) {
                return error("当前用户名已存在不允许添加！");
            } else {
                userService.addUser(user);
            }
        }
        return null;
    }

    /**
     * 管理员删除
     */
    @RequestMapping("/delete")
    @SystemControllerLog(description = "后台管理-用户删除")
    @ResponseBody
    @ApiOperation(value = "用户删除", httpMethod = "GET")
    public ApiResult delete(@RequestParam(value = "ids") String ids) throws Exception {
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            userService.deleteUser(idsStr[i]);
        }
        return null;
    }
}
