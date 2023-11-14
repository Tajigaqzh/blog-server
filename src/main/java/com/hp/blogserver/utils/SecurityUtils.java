package com.hp.blogserver.utils;


import com.hp.blogserver.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;


/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 8:38
 * @Version 1.0
 */
@Slf4j
public class SecurityUtils {

    public static String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        return ((User) authentication.getPrincipal()).getUsername();
    }

    public static User getUser() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return null;
        }
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
            return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return null;

    }

}
