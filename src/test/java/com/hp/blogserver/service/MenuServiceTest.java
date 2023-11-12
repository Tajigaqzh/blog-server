package com.hp.blogserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hp.blogserver.entity.Menu;
import com.hp.blogserver.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/9 19:36
 * @Version 1.0
 */
@SpringBootTest
public class MenuServiceTest {
    @Autowired
    MenuMapper menuMapper;

    @Test
    public void addMenu() {
//        Menu build = Menu.builder()
//                .deleteStatus(1).createTime(new Date())
//                .name("PermUpdate").path("/perm/update")
//                .title("更新权限")
//                .type(2)
//                .parentId(1L).rank(1).parentId(20L)
//                .showLink(true)
//                .build();
//        menuMapper.insert(build);
        System.out.println("aaa");
        List<Menu> menus = menuMapper.listMenu(new QueryWrapper<>());
        System.out.println(menus);
    }
}
