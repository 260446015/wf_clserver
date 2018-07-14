package com.zkjl.wf_clserver.core.aop;

import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.entity.JobBean;
import com.zkjl.wf_clserver.core.entity.Log;
import com.zkjl.wf_clserver.core.entity.LoginCount;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.repository.kklc.LoginCountRepository;
import com.zkjl.wf_clserver.core.repository.kklc.UserOperationRepository;
import com.zkjl.wf_clserver.core.util.IpUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
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
    @Resource(name = "primaryMongoTemplate")
    private MongoTemplate primaryMongoTemplate;

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
            String methodName = targetMethod.getName();
            Log log = new Log();
            String ip = IpUtils.getIpAddr(request);
            log.setIp(ip);
            log.setDescription(annotation.description());
            log.setArgs(Arrays.toString(joinPoint.getArgs()));
            if(methodName.equals("createJob")){
                log.setArgs(((JobBean)joinPoint.getArgs()[2]).getWord());
            }
            String name = user.getUsername();
            log.setName(name);
            log.setCreateDate(Calendar.getInstance().getTime());
            log.setIp(ip);
            primaryMongoTemplate.insert(log);
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
            loginCount.setIp(IpUtils.getIpAddr(request));
            loginCount.setName(user.getUsername());
            loginCountRepository.save(loginCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
