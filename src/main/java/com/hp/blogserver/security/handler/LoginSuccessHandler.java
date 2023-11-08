package com.hp.blogserver.security.handler;

import com.hp.blogserver.entity.Role;
import com.hp.blogserver.entity.User;
import com.hp.blogserver.utils.DateUtils;
import com.hp.blogserver.utils.JwtUtils;
import com.hp.blogserver.utils.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 20126
 * @Description 成功登录的处理器
 * @Date 2023/11/5 17:50
 * @Version 1.0
 */
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        User user = (User) auth.getPrincipal();

        String token = JwtUtils.token(auth);
        response.addHeader("token", token);

        response.setContentType("application/json;charset=UTF-8");
        Map<String, Object> data = new HashMap<>();
        data.put("username",user.getUsername());
        data.put("roles",user.getRoles().stream().map(Role::getTag).collect(Collectors.toList()));
        data.put("token",token);
//        data.put("refreshToken",token);
        data.put("expires", DateUtils.format(DateUtils.addDay(1)));

        log.info("登录成功 {}",user.getUsername());

        response.getWriter().write(Result.okJSON(data));
    }
}
