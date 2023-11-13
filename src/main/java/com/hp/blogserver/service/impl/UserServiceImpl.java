package com.hp.blogserver.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.blogserver.entity.*;
import com.hp.blogserver.mapper.UserMapper;
import com.hp.blogserver.service.*;
import com.hp.blogserver.utils.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 19:27
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IUserPermService userPermService;

    @Autowired
    IPermService permService;

    /**
     * 登录
     *
     * @param username the username identifying the user whose data is required.
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getByUsername(username);
        Asserts.isNull(user, "用户名未找到!");
        //将数据库中的角色拆分成SpringSecurity结构
        String roles = user.getRoles().stream().map(Role::getTag).collect(Collectors.joining(","));
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(roles));
        return user;
    }

    @Override
    public IPage<User> listPage(IPage<User> page, Wrapper<User> userWrapper) {
        return userMapper.listUser(page, userWrapper);
    }

    public int deleteBatchByIds(List<Long> ids) {
        return userMapper.deleteBatchIds(ids);
    }

    @Override
    @Transactional
    public boolean register(User user) {

        int insert = userMapper.insert(user);

        if (insert ==0) {
            return false;
        }

        Role one = roleService.getOne(new QueryWrapper<Role>().eq("tag", "admin"));

        UserRole userRole = UserRole.builder().userId(user.getId()).roleId(one.getId()).build();


        userRoleService.save(userRole);


        Permission perm = permService.getOne(new QueryWrapper<Permission>().eq("tag", "perm_all"));


        UserPerm build = UserPerm.builder().userId(user.getId()).permId(perm.getId()).build();

        userPermService.save(build);



        return true;
    }
}
