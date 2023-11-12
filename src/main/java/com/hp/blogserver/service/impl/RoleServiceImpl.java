package com.hp.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.blogserver.entity.Role;
import com.hp.blogserver.mapper.RoleMapper;
import com.hp.blogserver.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 22:32
 * @Version 1.0
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getSelectedRolesByMenuId(Long menuId) {
        return roleMapper.getSelectedRolesByMenuId(menuId);
    }

    @Override
    public List<Role> getSelectedRolesByUserId(Long userId) {
        return roleMapper.getRolesByUserId(userId);
    }
}
