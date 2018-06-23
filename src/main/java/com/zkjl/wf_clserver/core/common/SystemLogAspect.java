package com.zkjl.wf_clserver.core.common;

import com.zkjl.wf_clserver.core.entity.Log;
import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.service.LogService;
import com.zkjl.wf_clserver.core.util.UuidUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;


/**
 * 系统日志切面类
 *
 */
@Aspect
@Component
public class SystemLogAspect {
	
    private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);
    
    @Autowired(required=false)
    private HttpServletRequest request;

    @Autowired
    private LogService logService;
    /**
     * Controller层切点 注解拦截
     */
    /*@Pointcut("@annotation(com.huishu.lbs.common.SystemControllerLog)")*/
    @Pointcut("execution(* com.zkjl.wf_clserver.core.controller.*.*(..))")
    public void controllerAspect(){
    }
    long beginTime=0L;

    /**
     * 前置通知 用于拦截Controller层记录用户的操作的开始时间
     * @param joinPoint 切点
     * @throws InterruptedException 
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws InterruptedException{
    	beginTime = System.currentTimeMillis();
    }

    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     * @param joinPoint 切点
     */
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
    	 //读取session中的用户 
    	 HttpSession session = request.getSession();       
         SysUser user = (SysUser) session.getAttribute("currentUser");
        if(user !=null){
            String description="";       
            //日志类型(info:入库,error:错误)
            String type="info";
            String remoteAddr=getAddr(request);//请求的IP
            String requestUri=request.getRequestURI();//请求的Uri
            String method=request.getMethod();        //请求的方法类型(post/get)

            try {
            	description=getControllerMethodDescription2(joinPoint);
            } catch (Exception e) {
                e.printStackTrace();
            }    
            long endTime = System.currentTimeMillis();  //2、结束时间  
            Log log=new Log();
            log.setId(UuidUtils.creatUUID());
            log.setDescription(description);
            log.setIp(remoteAddr);
            log.setRequestUri(requestUri);
            log.setName(user.getName());
            log.setSysUserId(user.getId());
            log.setType(type);
            //log.setCategory(category);
            //1.直接执行保存操作
            logService.createLog(log);

        }

    }

    /**
     *  异常通知 记录操作报错日志
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")  
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
    	 //读取session中的用户 
   	 	HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("currentUser");
        Log log=new Log();
       if(user !=null){
           String title="";
           String remoteAddr=request.getRemoteAddr();//请求的IP
           String requestUri=request.getRequestURI();//请求的Uri
           String method=request.getMethod();        //请求的方法类型(post/get)

           try {
               title=getControllerMethodDescription2(joinPoint);
           } catch (Exception e1) {
               e1.printStackTrace();
           }    
           long endTime = System.currentTimeMillis();  //2、结束时间  
           log.setId(UuidUtils.creatUUID());
           log.setDescription(title);
           log.setType("error");
           log.setIp(remoteAddr);
           log.setRequestUri(requestUri);
           log.setName(user.getName());
           logService.createLog(log);
       }
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     * @paramjoinPoint切点s
     * @return discription
     */
    public static String getServiceMthodDescription2(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemServiceLog serviceLog = method
                .getAnnotation(SystemServiceLog.class);
        String discription="";
        if (null != serviceLog) {
        	discription = serviceLog.description();
		}
		return discription;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * 
     * @param joinPoint 切点
     * @return discription
     */
    public static String getControllerMethodDescription2(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemControllerLog controllerLog = method
                .getAnnotation(SystemControllerLog.class);
        String discription="";
        if (null != controllerLog) {
        	discription = controllerLog.description();
		}
		return discription;
    }
    public String getAddr(HttpServletRequest request){
    	
    		String ip=request.getHeader("x-forwarded-for");
           if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
             ip=request.getHeader("Proxy-Client-IP");
           }
            if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
             ip=request.getHeader("WL-Proxy-Client-IP");
           }
           if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
             ip=request.getRemoteAddr();
           }
         return ip;
    }
}