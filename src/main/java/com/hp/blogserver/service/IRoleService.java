package com.hp.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hp.blogserver.entity.Role;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 22:31
 * @Version 1.0
 */

public interface IRoleService extends IService<Role> {
    List<Role> getSelectedRolesByMenuId(Long menuId);

    List<Role> getSelectedRolesByUserId(Long userId);
}
