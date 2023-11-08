package com.hp.blogserver.security.handler;

import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.ResultCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 17:54
 * @Version 1.0
 */
@Slf4j
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        response.setContentType("application/json;charset=UTF-8");

        if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
            response.getWriter().write(Result.errorJSON(exception.getMessage(), ResultCode.NAME_PASS_ERROR));
        } else if (exception instanceof LockedException) {
            response.getWriter().write(Result.errorJSON("账户被锁定，请联系管理员!", ResultCode.NAME_PASS_ERROR));
        } else if (exception instanceof CredentialsExpiredException) {

            response.getWriter().write(Result.errorJSON("证书过期，请联系管理员", ResultCode.EXPIRE));
        } else if (exception instanceof AccountExpiredException) {
//            result = "账户过期，请联系管理员!";
            response.getWriter().write(Result.errorJSON("证书过期，请联系管理员", ResultCode.EXPIRE));
        } else if (exception instanceof DisabledException) {
//            result = "账户被禁用，请联系管理员!";
            response.getWriter().write(Result.errorJSON(exception.getMessage(), ResultCode.NAME_PASS_ERROR));
        } else {
            log.error("登录失败：", exception);
//            result = "登录失败!";
            response.getWriter().write(Result.errorJSON(exception.getMessage(), ResultCode.NAME_PASS_ERROR));

        }
    }
}
