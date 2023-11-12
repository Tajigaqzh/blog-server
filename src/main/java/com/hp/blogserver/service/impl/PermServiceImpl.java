package com.hp.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.blogserver.entity.Menu;
import com.hp.blogserver.entity.Permission;
import com.hp.blogserver.mapper.PermMapper;
import com.hp.blogserver.service.IPermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 16:37
 * @Version 1.0
 */
@Service
public class PermServiceImpl extends ServiceImpl<PermMapper, Permission> implements IPermService {

    @Autowired
    private PermMapper permMapper;


    public IPage<Permission> listPage(IPage<Menu> page, Wrapper<Permission> queryWrapper) {
        return permMapper.listPage(page, queryWrapper);
    }


    @Override
    public List<Permission> getSelectedPermissionByUserId(Long userId) {
        return permMapper.getPermissionByUserId(userId);
    }

    @Override
    public List<Permission> getSelectedPermissionByMenuId(Long menuId) {
        return permMapper.getSelectedPermissionByMenuId(menuId);
    }
}
