package com.hp.blogserver.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hp.blogserver.common.vo.RouteVO;
import com.hp.blogserver.entity.Menu;
import com.hp.blogserver.entity.Permission;
import com.hp.blogserver.entity.Role;
import com.hp.blogserver.service.IMenuService;
import com.hp.blogserver.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/14 22:35
 * @Version 1.0
 */
@Slf4j
@Component
public class RouteTools {
    @Autowired
    IMenuService menuService;

    @Autowired
    IUserService userService;

    public List<RouteVO> buildRouteTree() {
        //所有的父菜单
        List<Menu> roots = menuService.listMenu(new QueryWrapper<Menu>().eq("m.parent_id", 0L).eq("m.deleteStatus", 1));

        List<RouteVO> routes = new ArrayList<>();

        menu(roots, routes);

        return routes;
    }

    private void menu(List<Menu> roots, List<RouteVO> routes) {
        if (CollUtil.isNotEmpty(roots)) {
            for (Menu parent : roots) {
                RouteVO root = route(parent);

                if (parent.getType() == 0 && parent.getParentId() == 0) {
                    routes.add(root);
                }

                List<Menu> children = menuService.listMenu(new QueryWrapper<Menu>().eq("m.parent_id", parent.getId()).ne("m.type",2).eq("m.deleteStatus",1));
                if(CollUtil.isNotEmpty(children)){
                    List<RouteVO> childrenRoute = childRoute(children);
                    root.setChildren(childrenRoute);
                    menu(children,routes);
                }
            }
        }
    }

    private RouteVO route(Menu menu) {
        RouteVO root = new RouteVO();
        root.setPath(menu.getPath());
        root.setName(menu.getName());
        root.setComponent(menu.getComponent());

        RouteVO.Meta meta = new RouteVO.Meta();
        meta.setTitle(menu.getTitle());
        meta.setIcon(menu.getIcon());
        meta.setShowLink(menu.getShowLink());
        meta.setRank(menu.getRank());
        meta.setRoles(menu.getRoles().stream().map(Role::getTag).collect(Collectors.toList()));

        List<Permission> permissions = Objects.requireNonNull(SecurityUtils.getUser()).getPermissions();

        meta.setAuths(permissions.stream().map(Permission::getTag).collect(Collectors.toList()));
        root.setMeta(meta);
        return root;
    }
    private List<RouteVO> childRoute(List<Menu> menus){
        List<RouteVO> children = new ArrayList<>();
        if(CollUtil.isNotEmpty(menus)){
            for (Menu menu : menus) {
                RouteVO child = route(menu);
                children.add(child);
            }
        }

        return children;
    }

}
