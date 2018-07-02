package com.zkjl.wf_clserver.core.aop;

import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.entity.Log;
import com.zkjl.wf_clserver.core.entity.LoginCount;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.repository.kklc.LoginCountRepository;
import com.zkjl.wf_clserver.core.repository.kklc.UserOperationRepository;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;

/**
 * @author ydw
 * Created on 2018/6/23
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private UserOperationRepository userOperationRepository;
    @Autowired
    private LoginCountRepository loginCountRepository;

    @Pointcut(value = "execution(public * com.zkjl.wf_clserver.core.controller.*.*(..))")
    public void logPoint() { }
    @Pointcut(value = "execution(public * com.zkjl.wf_clserver.core.controller.UserController.login(..))")
    public void loginCountPoint(){ }

    @Before(value = "logPoint()")
    public void saveUserOperation(JoinPoint joinPoint) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        SystemControllerLog annotation = targetMethod.getAnnotation(SystemControllerLog.class);
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        System.out.println("当前session:"+ SecurityUtils.getSubject().getSession().getId());
        if (null != annotation && null != user) {
            Log log = new Log();
            String ip = getIpAddr(request);
            log.setIp(ip);
            log.setDescription(annotation.description());
            String name = user.getName();
            log.setName(name);
            log.setCreateDate(Calendar.getInstance().getTime());
            log.setIp(ip);
            userOperationRepository.save(log);
        }
    }

    @After(value = "loginCountPoint()")
    public void doSaveLoginCount(){
        try {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();
            LoginCount loginCount = new LoginCount();
            SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
            loginCount.setCreateTime(Calendar.getInstance().getTime());
            loginCount.setIp(getIpAddr(request));
            loginCount.setName(user.getName());
            loginCountRepository.save(loginCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前网络ip
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}
