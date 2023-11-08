package com.hp.blogserver.common;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 17:23
 * @Version 1.0
 */
@Data
@Configuration
public class HpConstant {
    /**
     * 放行的url
     */
    public static String[] anonymous = {
            "/register",
            "/login",
            "/unAuth",
            "/user/refreshToken",
            ".css",
            "**.css",
            ".js",
            "**.js",
            "/doc.html",
            "/swagger-ui",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/favicon.ico",
    };

    public static String[] anonymousStatic = {
            ".css",
            "**.css",
            ".js",
            "**.js",
            "/doc.html",
            "/swagger-ui",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/favicon.ico",
    };

    /**
     * 放行的url集合
     */
    public static List<String> anonymousList = Arrays.asList(anonymous);
}
