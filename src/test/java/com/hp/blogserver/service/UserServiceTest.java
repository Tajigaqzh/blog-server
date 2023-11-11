package com.hp.blogserver.service;

import com.hp.blogserver.entity.User;
import com.hp.blogserver.utils.SecurityUtils;
import org.activiti.engine.impl.identity.Authentication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/6 23:27
 * @Version 1.0
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void loginTest(){
        UserDetails userDetails = userService.loadUserByUsername("admin123");
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        authorities.forEach(System.out::print);
    }

    @Test
    public void getByIdTest(){
        User byId = userService.getById(null);
        System.out.println(byId);
    }

    @Test
    public void deleteByBatchIds(){
        ArrayList<Long> objects = new ArrayList<>();
        objects.add(1000L);
        boolean b = userService.removeBatchByIds(objects);
//        boolean b = userService.removeById(1000L);
        System.out.println(b);
    }

    @Test
    public void getLogin(){

    }
}
