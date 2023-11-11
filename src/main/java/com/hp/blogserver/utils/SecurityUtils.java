package com.hp.blogserver.utils;


import com.hp.blogserver.entity.User;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;


/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 8:38
 * @Version 1.0
 */

public class SecurityUtils {

    public static String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new AuthenticationCredentialsNotFoundException("Missing authentication object.");
        }
        User user = (User) authentication.getPrincipal();
        return user.getUsername();
    }
}
