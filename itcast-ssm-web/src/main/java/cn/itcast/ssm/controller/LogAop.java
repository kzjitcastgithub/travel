package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.SysLog;
import cn.itcast.ssm.service.SysLogService;
import cn.itcast.ssm.util.DateUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    SysLogService sysLogService;

    @Autowired
    HttpServletRequest request;

    private Date startTime;
    private Class executionClass;
    private Method executionMethod;

    @Before("execution(* cn.itcast.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws Exception{
        startTime = new Date();
        executionClass = joinPoint.getTarget().getClass();
        String executionName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        if(args.length==0||args==null){
            executionMethod = executionClass.getMethod(executionName);
        }else{
            Class[] classArgs = new Class[args.length];
            for(int i=0; i<args.length; i++){
                classArgs[i] = args[i].getClass();
            }
            executionMethod = executionClass.getMethod(executionName, classArgs);
        }
    }

    @After("execution(* cn.itcast.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception{
        if(executionClass != null && executionMethod != null && executionClass != LogAop.class){
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            if(classAnnotation != null){
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if(methodAnnotation != null){
                    String url = "";
                    url = classAnnotation.value()[0] + methodAnnotation.value()[0];
                    SysLog sysLog = new SysLog();
                    //
                    sysLog.setVisitTime(DateUtil.Date2String("yyyy-MM-dd HH:mm:ss",startTime));
                    Long executeTime = new Date().getTime() - startTime.getTime();
                    //
                    sysLog.setExecuteTime(executeTime);
                    SecurityContext securityContext = SecurityContextHolder.getContext();
                    String username = ((User) (securityContext.getAuthentication().getPrincipal())).getUsername();
                    //
                    sysLog.setUsername(username);
                    //
                    sysLog.setIp(request.getRemoteAddr());
                    //
                    sysLog.setUrl(url);
                    //
                    sysLog.setMethod("[类名 ]"+executionClass.getName()+"[方法名 ]"+executionMethod.getName());
                    System.out.println(sysLog);
                    sysLogService.insertSysLog(sysLog);
                }
            }
        }

    }

}
