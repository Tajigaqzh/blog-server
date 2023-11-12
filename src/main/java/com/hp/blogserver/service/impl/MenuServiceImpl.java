package com.hp.blogserver.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.blogserver.common.dto.AuthRolePermDto;
import com.hp.blogserver.entity.Menu;
import com.hp.blogserver.entity.MenuPerm;
import com.hp.blogserver.entity.MenuRole;
import com.hp.blogserver.mapper.MenuMapper;
import com.hp.blogserver.service.IMenuPermService;
import com.hp.blogserver.service.IMenuRoleService;
import com.hp.blogserver.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 19:27
 * @Version 1.0
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private IMenuPermService menuPermService;

    @Autowired
    private IMenuRoleService menuRoleService;

    @Override
    public List<Menu> listMenu(Wrapper<Menu> wrapper) {
        return menuMapper.listMenu(wrapper);
    }

    @Override
    public IPage<Menu> listPage(IPage<Menu> page, Wrapper<Menu> queryWrapper) {
        return menuMapper.listPage(page, queryWrapper);
    }


    @Override
    @Transactional
    public boolean saveAuth(AuthRolePermDto menuRolePerm) {
        //先删除已有的权限/角色
        menuRoleService.remove(new QueryWrapper<MenuRole>().eq("menu_id", menuRolePerm.getId()));
        menuPermService.remove(new QueryWrapper<MenuPerm>().eq("menu_id", menuRolePerm.getId()));

        //role不为，更新role
        if (CollUtil.isNotEmpty(menuRolePerm.getRoles())) {
            List<MenuRole> menuRoles = new ArrayList<>();
            for (Long roleId : menuRolePerm.getRoles()) {
                MenuRole build = MenuRole.builder().menuId(menuRolePerm.getId()).roleId(roleId).build();
                menuRoles.add(build);
            }
            menuRoleService.saveBatch(menuRoles);
        }
        //权限不为空，更新权限
        if (CollUtil.isNotEmpty(menuRolePerm.getPerms())) {
            List<MenuPerm> menuPerms = new ArrayList<>();
            for (Long permId : menuRolePerm.getPerms()) {
                MenuPerm build = MenuPerm.builder().menuId(menuRolePerm.getId()).permId(permId).build();
                menuPerms.add(build);
            }
            menuPermService.saveBatch(menuPerms);
        }
        return true;
    }
}
