package com.hp.blogserver.security.handler;

import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.ResultCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author 20126
 * @Description 拒绝访问处理器
 * @Date 2023/11/5 17:57
 * @Version 1.0
 */
@Slf4j
@Component
public class NoAuthAccessDeniedHandler implements AccessDeniedHandler {

    @SneakyThrows
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info("认证未通过:{}",accessDeniedException.getMessage());
        // 这里可以记录一下日志
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(403);
        response.getWriter().write(Result.errorJSON(accessDeniedException.getMessage(), ResultCode.EXPIRE));
    }
}
