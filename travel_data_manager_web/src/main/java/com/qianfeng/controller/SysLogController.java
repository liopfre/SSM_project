package com.qianfeng.controller;

import com.qianfeng.domain.SysLog;
import com.qianfeng.service.ISysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 作者：YoriStar
 * 时间：2023/7/10 20:52
 * 描述：TODO
 */
@Component
@Aspect
@RequestMapping("/sysLog")
public class SysLogController {


    @Resource
    ISysLogService iSysLogService;

    @Resource
    ServletRequest request;

    @Pointcut(value = "execution(* com.qianfeng.controller.*.*(..))")
    public void pt1(){

    }

    @Around(value = "pt1()")
    public Object around(ProceedingJoinPoint pdj) throws Throwable {
        SysLog sysLog = new SysLog();
        //sysLog UUID
        sysLog.setId(UUID.randomUUID().toString());
        //visitTime
        Date visitTime = new Date();
        sysLog.setVisitTime(visitTime);
        //username
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        sysLog.setUsername(username);
        //ip
        sysLog.setIp(request.getRemoteAddr());
        //classURL
        Object target = pdj.getTarget();
        Class<?> aClass = target.getClass();
        String classUrl="";
        if (aClass.isAnnotationPresent(RequestMapping.class)){
             classUrl = aClass.getAnnotation(RequestMapping.class).value()[0];
        }
            //methodURL
        String methodName = pdj.getSignature().getName();
        Object[] args = pdj.getArgs();
        Class[] classes=new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            classes[i]=args[i].getClass();
        }
        Method method = aClass.getMethod(methodName, classes);
        String methodUrl="";
        if (method.isAnnotationPresent(RequestMapping.class)){
            methodUrl = method.getAnnotation(RequestMapping.class).value()[0];
        }
        String url=classUrl+methodUrl;
        sysLog.setUrl(url);

        //sysLog method column
        String methodPath="[类名]"+aClass.getName()+"[方法名]"+method.getName();
        sysLog.setMethod(methodPath);

        Object result = pdj.proceed(pdj.getArgs());

        //executionTime
        long executionTime = new Date().getTime() - visitTime.getTime();
        sysLog.setExecutionTime(executionTime);
        iSysLogService.addSysLog(sysLog);
        return result;
    }


    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<SysLog> sysLogs=iSysLogService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("syslog-list");
        mav.addObject("sysLogs",sysLogs);
        return mav;
    }
}
