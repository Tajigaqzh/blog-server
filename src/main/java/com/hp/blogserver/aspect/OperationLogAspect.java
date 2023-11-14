package com.hp.blogserver.aspect;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson.JSON;
import com.hp.blogserver.entity.ExceptionLog;
import com.hp.blogserver.service.IExceptionLogService;
import jakarta.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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

    @Autowired
    IExceptionLogService exceptionLogService;

    @Pointcut("@annotation(io.swagger.v3.oas.annotations.Operation)")
    public void OperationPointCut() {
        log.info("operLogPoinCut()。。。。");
    }

    @Pointcut("execution(* com.hp.blogserver.controller..*.*(..))")
    public void operationExceptionLogPointCut() {
        log.error("operationExceptionLogPointCut");
    }

    @AfterReturning(value = "OperationPointCut()", returning = "returnMessage")
    public void saveOperation(JoinPoint joinPoint, Object returnMessage){

    }
    /**
     * 保存异常信息
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(pointcut = "operationExceptionLogPointCut()", throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint, Throwable e) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (requestAttributes != null) {
            request = (HttpServletRequest) requestAttributes
                    .resolveReference(RequestAttributes.REFERENCE_REQUEST);
        }

        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();

            Method method = signature.getMethod();

            String methodName = joinPoint.getTarget().getClass().getName() + "." + method.getName();

            // 请求的参数
            Map<String, String> rtnMap = null;
            if (request != null) {
                rtnMap = convertMap(request.getParameterMap());
            }
            // 将参数所在的数组转换成json
            String params = JSON.toJSONString(rtnMap);

            ExceptionLog build = ExceptionLog.builder().excRequParam(params)
                    .operMethod(methodName)
                    .excName(e.getClass().getName())
                    .excMessage(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace()))
                    .operUserId("test")
                    .operUserName("测试用户").build();

            if (request != null) {
                String clientIP = getClientIP(request, "X-Forwarded-For", "X-Real-IP");
                build.setOperIp(clientIP);
                build.setOperUri(request.getRequestURI());

            }
            build.setOperCreateTime(new Date());
            log.info(JSON.toJSONString(build));

            exceptionLogService.save(build);

        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }


    private Map<String, String> convertMap(Map<String, String[]> originMap) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();

        for (String s : originMap.keySet()) {
            stringStringHashMap.put(s, originMap.get(s)[0]);
        }

        return stringStringHashMap;
    }

    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        //StringBuffer 线程安全 StringBuilder 速度快
        StringBuilder strbuff = new StringBuilder();
        for (StackTraceElement stet : elements) {
            //为什么不连在一起append 因为 连在一起会多出一个字符串 多出内存开销
            strbuff.append(stet);
            strbuff.append("\n");
        }
        return exceptionName + ":" + exceptionMessage + "\n\t" + strbuff.toString();
    }

    private static String getClientIP(HttpServletRequest request, String... otherHeaderNames) {
        String[] headers = {"X-Forwarded-For", "X-Real-IP", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"};
        if (ArrayUtil.isNotEmpty(otherHeaderNames)) {
            headers = ArrayUtil.addAll(headers, otherHeaderNames);
        }
        return getClientIPByHeader(request, headers);
    }

    private static String getClientIPByHeader(HttpServletRequest request, String... headerNames) {
        String ip;
        for (String header : headerNames) {
            ip = request.getHeader(header);
            if (!NetUtil.isUnknown(ip)) {
                return NetUtil.getMultistageReverseProxyIp(ip);
            }
        }

        ip = request.getRemoteAddr();
        return NetUtil.getMultistageReverseProxyIp(ip);
    }
}
