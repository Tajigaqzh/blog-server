package com.hp.blogserver.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hp.blogserver.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/6 20:30
 * @Version 1.0
 */
@SpringBootTest
public class UserMapperTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void selectUserTest() {
        User admin123 = userMapper.getByUsername("admin1234");
        System.out.println(admin123);
    }

    @Test
    public void selectByName() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void listUserTest(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        IPage<User> userIPage = userMapper.listUser(new Page<>(1, 10), wrapper);
        System.out.println(userIPage.getRecords());
    }



}
