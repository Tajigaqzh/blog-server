package com.hp.blogserver.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hp.blogserver.common.vo.MenuPermTreeVO;
import com.hp.blogserver.entity.Menu;
import com.hp.blogserver.entity.Permission;
import com.hp.blogserver.service.IMenuService;
import com.hp.blogserver.service.IPermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 19:24
 * @Version 1.0
 */
@Component
public class AuthTools {
    @Autowired
    IPermService permService;

    @Autowired
    IMenuService menuService;


    public List<MenuPermTreeVO> getMenus() {
        List<Menu> menus = menuService.list(new QueryWrapper<Menu>().ne("type", 2));
        List<Permission> permissions = permService.list();
        List<MenuPermTreeVO> menuPerms = new ArrayList<>();
        for (Menu menu : menus) {
            for (Permission permission : permissions) {
                if (Objects.equals(permission.getMenuId(), menu.getId())) {
                    MenuPermTreeVO menuPermTreeVO = new MenuPermTreeVO();
                    menuPermTreeVO.setId(permission.getId());
                    menuPermTreeVO.setName(permission.getName() + ":" + permission.getTag());
                    menuPermTreeVO.setParentId(permission.getMenuId()+10000);
                    menuPerms.add(menuPermTreeVO);

                } else {
                    MenuPermTreeVO menuPermTreeVO = new MenuPermTreeVO();
                    menuPermTreeVO.setId(menu.getId()+10000);//防止和perm的id冲突
                    menuPermTreeVO.setName(menu.getTitle());
                    menuPermTreeVO.setParentId(menu.getParentId()+10000);
                    menuPermTreeVO.setDisabled(true);
                    menuPerms.add(menuPermTreeVO);
                }
            }
        }

        TreeSet<MenuPermTreeVO> menuPermTreeVOSet = new TreeSet<>(new Comparator<MenuPermTreeVO>() {
            @Override
            public int compare(MenuPermTreeVO o1, MenuPermTreeVO o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        menuPermTreeVOSet.addAll(menuPerms);
        return new ArrayList<>(menuPermTreeVOSet);
    }
}
