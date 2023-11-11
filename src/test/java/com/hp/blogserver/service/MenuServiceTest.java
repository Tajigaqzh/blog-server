package com.hp.blogserver.service;

import com.hp.blogserver.entity.Menu;
import com.hp.blogserver.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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
        Menu build = Menu.builder()
                .deleteStatus(1).createTime(new Date())
                .name("userGetId").path("/user/getById")
                .title("根据id查询")
                .type(2)
                .parentId(1L).rank(1).parentId(2L)
                .showLink(true)
                .build();
        menuMapper.insert(build);
    }
}
