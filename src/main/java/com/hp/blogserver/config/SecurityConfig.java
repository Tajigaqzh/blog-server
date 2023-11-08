package com.hp.blogserver.config;

import com.hp.blogserver.common.HpConstant;
import com.hp.blogserver.security.auth.MyAuthorizationManager;
import com.hp.blogserver.security.filter.JwtAuthenticationTokenFilter;
import com.hp.blogserver.security.filter.LoginAuthenticationFilter;
import com.hp.blogserver.security.handler.LoginFailureHandler;
import com.hp.blogserver.security.handler.LoginSuccessHandler;
import com.hp.blogserver.security.handler.NoAuthAccessDeniedHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 17:20
 * @Version 1.0
 */
@Configuration
@Slf4j
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    NoAuthAccessDeniedHandler noAuthAccessDeniedHandler;
    @Autowired
    private MyAuthorizationManager authorizationManager;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //放行一些匿名请求
        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry
                -> authorizationManagerRequestMatcherRegistry
                .requestMatchers(HttpMethod.POST,"/register","/refreshToken","/login").permitAll()
                .requestMatchers(HttpMethod.GET,HpConstant.anonymousStatic).permitAll()

        );
        http.authorizeHttpRequests(e
                -> e.requestMatchers(RegexRequestMatcher
                        .regexMatcher("^\\S*[css|js]$"))
                .permitAll()
        );
        http.authorizeHttpRequests(e -> e.anyRequest().access(authorizationManager));
        //登录之前验证token
        http.addFilterBefore(new JwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        http.addFilterAt(loginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling(e -> e.accessDeniedHandler(noAuthAccessDeniedHandler));

        http.csrf(CsrfConfigurer::disable);
        http.cors(CorsConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    public LoginAuthenticationFilter loginAuthenticationFilter() throws Exception {
        LoginAuthenticationFilter filter = new LoginAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new LoginSuccessHandler());
        filter.setAuthenticationFailureHandler(new LoginFailureHandler());
        //LoginAuthenticationFilter 中需要使用到AuthenticationManager 不加会出现空指针
        filter.setAuthenticationManager(authenticationConfiguration.getAuthenticationManager());
        return filter;
    }
}
