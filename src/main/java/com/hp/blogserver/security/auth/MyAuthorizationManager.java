package com.hp.blogserver.security.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hp.blogserver.common.HpConstant;
import com.hp.blogserver.entity.Permission;
import com.hp.blogserver.entity.User;
import com.hp.blogserver.entity.Menu;
import com.hp.blogserver.mapper.MenuMapper;
import com.hp.blogserver.mapper.UserMapper;
import com.hp.blogserver.utils.HpTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 17:20
 * @Version 1.0
 */
@Component
public class MyAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public void verify(Supplier<Authentication> authentication, RequestAuthorizationContext requestAuthorizationContext) {
        AuthorizationManager.super.verify(authentication, requestAuthorizationContext);
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext requestAuthorizationContext) {
        if (!(authentication.get().getPrincipal() instanceof User user)) {
            throw new AccessDeniedException("匿名不可访问!");
        }

        user = userMapper.getByUsername(user.getUsername());

        //当前登录人的权限
        List<String> auths = user.getPermissions().stream().map(Permission::getTag).toList();

        //访问的接口地址
        String requestURI = requestAuthorizationContext.getRequest().getRequestURI();

        //匿名地址直接访问
        if (HpTools.contains(requestURI, HpConstant.anonymous)) {
            return new AuthorizationDecision(true);
        }

        //查询当前请求的接口需要哪些权限能访问
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("m.type", 2);
        //2是接口
        queryWrapper.eq("m.path", requestURI);
        List<Menu> menus = menuMapper.listMenu(queryWrapper);


        /**
         * 动态验证权限
         */
        for (String auth : auths) {
            for (Menu menu : menus) {
                List<String> collect = menu.getPerms().stream().map(Permission::getTag).toList();
                if (collect.contains(auth)) {
                    return new AuthorizationDecision(true);
                }
            }
        }

        throw new AccessDeniedException(user.getUsername() + "没有访问" + requestURI + "的权限");
    }
}
