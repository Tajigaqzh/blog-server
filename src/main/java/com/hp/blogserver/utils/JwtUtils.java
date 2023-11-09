package com.hp.blogserver.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 17:33
 * @Version 1.0
 */
@Component
public class JwtUtils {
    @Autowired
    private Environment environment;

    private static String secretKey;

    private static int expires = 1000 * 60 * 60 * 24 * 5;

    @PostConstruct
    public void initValue() {
        secretKey = environment.getProperty("jwt.secret");
        expires = Integer.parseInt(Objects.requireNonNull(environment.getProperty("jwt.expires")));
    }

    /**
     * 生成Token
     *
     * @param authentication 认证信息
     * @return token
     */
    public static String token(Authentication authentication) {
        System.out.println("secret" + secretKey);
        System.out.println("expires = " + expires);
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + expires))  //设置过期时间:单位毫秒,1天
                .withAudience(JSON.toJSONString(authentication)) //设置接受方信息，一般时登录用户
                .sign(Algorithm.HMAC256(secretKey));
    }

    /**
     * 根据指定日期返回token
     *
     * @param authentication 认证信息
     * @param time           过期时间 单位毫秒
     * @return 返回token
     */
    public static String token(Authentication authentication, Long time) {
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + expires))  //设置过期时间:单位毫秒
                .withAudience(JSON.toJSONString(authentication)) //设置接受方信息，一般时登录用户
                .sign(Algorithm.HMAC256(secretKey));
    }

    /**
     * 验证token合法性
     */
    public static void tokenVerify(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
        jwtVerifier.verify(token);//没报错说明验证成功
        JWT.decode(token).getExpiresAt();
        String json = JWT.decode(token).getAudience().get(0);
        JwtAuthentication jwtAuthentication = JSON.parseObject(json, JwtAuthentication.class);
        SecurityContextHolder.getContext().setAuthentication(jwtAuthentication);
    }

    /**
     * 刷新token
     *
     * @param token 旧的token
     * @return token
     */
    public static String refreshToken(String token) {
        JwtUtils.tokenVerify(token);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return JwtUtils.token(authentication);
    }


}
