package com.hp.blogserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hp.blogserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 16:04
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return User
     */
    User getByUsername(@Param("username") String username);

    /**
     * 根据条件查询多个user
     * @param page 分页器
     * @param userWrapper wrapper
     * @return IPage<User>
     */
    IPage<User> listUser(IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> userWrapper);
}
