package com.hp.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.blogserver.entity.Role;
import com.hp.blogserver.entity.User;
import com.hp.blogserver.mapper.UserMapper;
import com.hp.blogserver.service.IUserService;
import com.hp.blogserver.utils.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

    /**
     * 登录
     * @param username the username identifying the user whose data is required.
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getByUsername(username);
        Asserts.isNull(user,"用户名未找到!");

        //将数据库中的角色拆分成SpringSecurity结构
        String roles = user.getRoles().stream().map(Role::getTag).collect(Collectors.joining(","));

        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(roles));

        return user;
    }

    @Override
    public IPage<User> listPage(IPage<User> page, Wrapper<User> userWrapper) {
        return userMapper.listUser(page,userWrapper);
    }
}
