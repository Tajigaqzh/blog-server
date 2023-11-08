package com.hp.blogserver.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hp.blogserver.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 19:27
 * @Version 1.0
 */
public interface IUserService extends IService<User>, UserDetailsService {
    IPage<User> listPage(IPage<User> page, @Param(Constants.WRAPPER)Wrapper<User> userWrapper);
}
