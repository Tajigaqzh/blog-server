package com.hp.blogserver.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public boolean saveUser(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User user1 = userMapper.selectOne(queryWrapper);
        if (ObjectUtil.isNull(user1)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            System.out.println(user);
            int insert = userMapper.insert(user);
            System.out.println(insert);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("username", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int update = userMapper.update(user, userUpdateWrapper);
        return update > 0;
    }

}
