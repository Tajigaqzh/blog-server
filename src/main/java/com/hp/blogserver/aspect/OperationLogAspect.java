package com.hp.blogserver.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @Author 20126
 * @Description 记录错误日志
 * @Date 2023/11/5 15:36
 * @Version 1.0
 * @see com.hp.blogserver.controller.system.UserController example
 */
@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    public void OperationPointCut(){

    }
    @Pointcut("execution(* com.hp.blogserver.controller..*.*(..))")
    public void operationExceptionLogPointCut(){
        log.error("operationExceptionLogPointCut");
    }

    @AfterThrowing(pointcut = "operationExceptionLogPointCut()", throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint,Throwable e){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (requestAttributes != null) {
            request = (HttpServletRequest) requestAttributes
                    .resolveReference(RequestAttributes.REFERENCE_REQUEST);
        }

    }
}
