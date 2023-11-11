package com.hp.blogserver.security.filter;

import cn.hutool.json.JSONUtil;
import com.hp.blogserver.common.HpConstant;
import com.hp.blogserver.utils.HpTools;
import com.hp.blogserver.utils.JwtUtils;
import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.ResultCode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 17:30
 * @Version 1.0
 * * 登录之前获取token校验:如果有token、再去校验token的合法性:如果没有报错 则认为登录成功
 * * 【token是根据SpringSecurity的Authentication生成的,相当于token就是SpringSecurity认证后的凭证】
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        //匿名地址直接访问
        if (HpTools.contains(requestURI, HpConstant.anonymous)) {
            filterChain.doFilter(request, response);
            return;
        }

        //获取JWT
        String token = request.getHeader("Authorization");
        if (token != null) {
            try {
                JwtUtils.tokenVerify(token);
            } catch (Exception e) {
                response.setStatus(401);
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(JSONUtil.toJsonStr(Result.error(null, ResultCode.NONE_TOKEN)));
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
