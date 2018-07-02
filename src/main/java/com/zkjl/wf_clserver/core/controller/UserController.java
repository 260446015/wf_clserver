package com.zkjl.wf_clserver.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户操作
 */
@RestController
@RequestMapping("/api/user")
@Api(value = "User-API", description = "这是用户接口详细信息的描述")
public class UserController extends BaseController {

    @Resource
    private UserService userService;
    private static final Logger log = Logger.getLogger(UserController.class);// 日志文件

    /**
     * 登录
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "根据登录用户的姓名密码进行校验，返回登录数据", httpMethod = "POST")
    public ApiResult login(String username, String password) {
        try {
            SysUser login = userService.login(username, password);
            JSONObject jsonObject = JSONObject.parseObject(login.toString());
            return success(jsonObject);
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
       /* if (subject.isAuthenticated()) {
            subject.logout();
            return "logout->success";
        }*/
        try {
            subject.logout();
        } catch (Exception e) {
            return "logout->error";
        }
        return "logout->success";
    }

    /**
     * 查询
     */
    @GetMapping("/list")
    @SystemControllerLog(description = "后台管理-用户列表查询")
    @ResponseBody
    @ApiOperation(value = "用户列表查询")
    public ApiResult list(Integer pageSize, Integer pageNum, String searchStr) throws Exception {
        PageImpl<SysUser> user;
        try {
            user = userService.findUser(pageSize, pageNum, searchStr);
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
    public ApiResult save(@RequestBody SysUser user) throws Exception {
        return success(userService.addUserOrUpdate(user));
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

    /**
     * 统计用户访问量
     */
    @RequestMapping("/visits")
    @SystemControllerLog(description = "后台管理-当前访问量")
    @ResponseBody
    @ApiOperation(value = "当前在线用户/总用户", httpMethod = "GET")
    public ApiResult userVisits(){
        JSONObject result;
        try {
            result = userService.listActiveSession();
        } catch (Exception e) {
            return error("用户在线查询失败");
        }
        return success(result);
    }
}
