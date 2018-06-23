package com.zkjl.wf_clserver.core.aop;

import com.zkjl.wf_clserver.core.repository.kklc.UserOperationRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ydw
 * Created on 2018/6/23
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private UserOperationRepository userOperationRepository;
    @Pointcut(value = "execution(public * com.zkjl.wf_clserver.core.controller.*.*(..))")
    public void logPoint(){

    }

    @Before(value = "logPoint()")
    public void saveUserOperation(JoinPoint joinPoint){
//        joinPoint.
//        userOperationRepository.
    }
}
