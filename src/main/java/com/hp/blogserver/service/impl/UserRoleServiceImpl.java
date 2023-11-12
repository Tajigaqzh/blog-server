package com.hp.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.blogserver.entity.UserRole;
import com.hp.blogserver.mapper.UserRoleMapper;
import com.hp.blogserver.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Author 20126
 * @Description 用户-角色 实现类
 * @Date 2023/11/12 17:12
 * @Version 1.0
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
