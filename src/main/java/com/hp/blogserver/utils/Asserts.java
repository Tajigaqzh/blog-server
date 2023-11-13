package com.hp.blogserver.utils;

import cn.hutool.core.collection.CollUtil;
import com.hp.blogserver.entity.Menu;
import com.hp.blogserver.entity.Role;
import com.hp.blogserver.exception.UserHasExistException;
import org.springframework.security.authorization.AuthorizationDecision;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 19:29
 * @Version 1.0
 */
public class Asserts {

    public static void isTrue(boolean b, String msg) {
        if (b) {
            throw new RuntimeException(msg);
        }
    }

    public static void isNull(Object obj, String msg) {
        if (obj == null) {
            throw new RuntimeException(msg);
        }
    }

    public static void isNotNull(Object obj, String msg) {
        if (obj != null) {
            throw new RuntimeException(msg);
        }
    }

    public static void exist(Object obj) {
        if (obj != null) {
            throw new UserHasExistException();
        }
    }

    public static void isGuest(List<Menu> menus, AuthorizationDecision authorizationDecision) {

    }


    public boolean isGuest(List<Menu> menus) {

        for (Menu menu : menus) {
            if (CollUtil.isNotEmpty(menu.getRoles())) {
                for (Role role : menu.getRoles()) {
                    if (role.getTag().equalsIgnoreCase("GUEST")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

