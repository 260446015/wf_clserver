package com.zkjl.wf_clserver.core.aop;

import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.repository.kklc.SysUserRepository;
import com.zkjl.wf_clserver.core.security.ShiroUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yindawei
 * @date 2018/9/19 10:14
 **/
@Component
@Aspect
public class AuthorizeAop {

    @Pointcut(value = "execution(public * com.zkjl.wf_clserver.core.controller.*.*(..)) && !execution(public * com.zkjl.wf_clserver.core.controller.UserController.login(..))")
    public void authorize() { }
    @Resource
    private SysUserRepository sysUserRepository;

    @Before(value = "authorize()")
    public void doAuthorize(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();
        String authorization = request.getHeader("Authorization");
        if(StringUtils.isBlank(authorization)){
            return;
        }
        SysUser user = sysUserRepository.findByToken(authorization);
        if(user == null){
            ShiroUtil.writeResponse(response,"令牌不正确");
            throw new RuntimeException();
        }
        SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUsername(),user.getPassword(),request.getRemoteHost()));
    }
}
