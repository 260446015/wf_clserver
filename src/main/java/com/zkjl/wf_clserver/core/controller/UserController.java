package com.zkjl.wf_clserver.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.dto.req.DefaultPageRQ;
import com.zkjl.wf_clserver.core.dto.vo.SysuserVO;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.service.ConfsService;
import com.zkjl.wf_clserver.core.service.LogService;
import com.zkjl.wf_clserver.core.service.UserService;
import com.zkjl.wf_clserver.core.util.IpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

/**
 * 用户操作
 */
@Controller
@RequestMapping("/api/user")
@Api(value = "User-API", description = "这是用户接口详细信息的描述")
public class UserController extends BaseController {

    @Resource
    private UserService userService;
    private static final Logger log = Logger.getLogger(UserController.class);// 日志文件
    @Resource
    private EhCacheManager ehCacheManager;
    @Resource
    private LogService logService;
    @Resource
    private ConfsService confsService;

    /**
     * 登录
     */
    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "用户登录", notes = "根据登录用户的姓名密码进行校验，返回登录数据", httpMethod = "POST")
    public ApiResult login(String username, String password, String mode, HttpServletRequest request) {
        try {
            SysUser login = userService.login(username, password);
            if (login == null) {
                return error("账号密码错误!");
            }
            if (login.getIfEnable() == false) {
                return error("该账号已被关闭！");
            }
            SysuserVO vo = new SysuserVO();
            BeanUtils.copyProperties(login, vo);
            JSONObject jsonObject = JSONObject.parseObject(vo.toString());
            jsonObject.put("ip", IpUtils.getIpAddr(request));
            if (mode.equals("front")) {
                ehCacheManager.getCache("shiroCache").put(login.getUsername(), login);
                return success(jsonObject);
            } else if (mode.equals("admin")) {
                if (login.getIfAdmin()) {
                    ehCacheManager.getCache("shiroCache").put(login.getUsername(), login);
                    return success(jsonObject);
                } else {
                    return error("用户权限不足！");
                }

            }
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
    @ResponseBody
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
    @ResponseBody
    @ApiOperation(value = "用户列表查询", httpMethod = "GET")
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
     * 根据id查询用户
     */
    @ApiOperation(value = "根据id查询用户", httpMethod = "GET")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @RequiresPermissions(value = "admin")
    @ResponseBody
    public ApiResult getUserById(@RequestParam String id) {
        Optional<SysUser> user;
        try {
            user = userService.findById(id);
        } catch (Exception e) {
            return error("查询用户列表失败");
        }
        return success(user);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "用户列表查询", httpMethod = "GET")
    @RequestMapping(value = "/page/list", method = RequestMethod.GET)
    @RequiresPermissions(value = "admin")
    @ResponseBody
    public ApiResult findPage(DefaultPageRQ defaultPageRQ,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) Date beginDate,
                              @RequestParam(required = false) Date endDate) {
        PageImpl<SysUser> user;
        try {
            user = userService.findPage(defaultPageRQ.getPageSize(), defaultPageRQ.getPageNum(), name, beginDate, endDate);
        } catch (Exception e) {
            return error("查询用户列表失败");
        }
        return successPages(user);
    }

    /**
     * 管理员添加或修改
     */
    @PostMapping("/save")
    @ResponseBody
    @ApiOperation(value = "用户添加", httpMethod = "POST")
    public ApiResult save(@RequestBody SysUser user, HttpServletRequest request) throws Exception {
        return success(userService.addUserOrUpdate(user));
    }

    /**
     * 管理员修改密码
     */
    @PostMapping("/updatePassword")
    @ResponseBody
    @RequiresPermissions(value = "admin")
    @ApiOperation(value = "修改密码", httpMethod = "POST")
    public ApiResult updatePassword(@RequestBody SysUser user) throws Exception {
        Optional<SysUser> opuser = userService.findById(user.getId());
        SysUser sysuser = opuser.get();
        sysuser.setPassword(user.getPassword());
        return success(userService.addUserOrUpdate(sysuser));
    }

    /**
     * 管理员更改状态
     **/
    @PostMapping("/updateStatus")
    @ResponseBody
    @RequiresPermissions(value = "admin")
    @ApiOperation(value = "更改状态", httpMethod = "POST")
    public ApiResult updateStatus(String id) throws Exception {
        return success(userService.enable(id));
    }

    /**
     * 管理员删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    @RequiresPermissions(value = "admin")
    @ApiOperation(value = "用户删除", httpMethod = "GET")
    public ApiResult delete(@RequestParam(value = "ids") String ids) throws Exception {
        ApiResult apiResult = new ApiResult();
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            userService.deleteUser(idsStr[i]);
        }
        return apiResult;
    }

    /**
     * 统计用户访问量
     */
    @RequestMapping("/visits")
    @ResponseBody
    @ApiOperation(value = "当前在线用户/总用户", httpMethod = "GET")
    public ApiResult userVisits() {
        JSONObject result;
        try {
            result = userService.listActiveSession();
        } catch (Exception e) {
            return error("用户在线查询失败");
        }
        return success(result);
    }

    @GetMapping(value = "login")
    public String login() {
//        if(getCurrentUser() == null){
//            modelAndView.setViewName("/front/login.html");
//        }else{
//            modelAndView.setViewName("/front/index.html");
//        }
        return "/front/login.html";
    }

    @GetMapping(value = "copy")
    @ResponseBody
    public ApiResult copy(String id) {
        if (StringUtils.isBlank(id)) {
            return error("拷贝的id没有传递");
        }
        try {
            confsService.copy(id);
        } catch (Exception e) {
            return error("出现错误:" + e.getMessage());
        }
        return success("拷贝成功,请刷新当前页面！");
    }

    /**
     * 普通用户修改密码
     */
    @GetMapping("/updatePassword2")
    @ResponseBody
    @ApiOperation(value = "修改密码", httpMethod = "GET")
    public ApiResult updatePassword2(String oldPassword, String newPassword, String id) throws Exception {
        boolean flag;
        try {
            flag = userService.updatePassword(oldPassword, newPassword, id);
        } catch (Exception e) {
            log.error("普通用户修改密码失败!" + e.getMessage());
            return error("用户修改密码失败!");
        }
        return success(flag);
    }
}