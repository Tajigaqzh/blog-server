package com.hp.blogserver.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hp.blogserver.entity.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/8 21:27
 * @Version 1.0
 */
@SpringBootTest
public class MenuMapperTest {
    @Autowired MenuMapper menuMapper;

    @Test
    public void selectByParentIdTest(){
        Menu menu = menuMapper.selectByParentId(1L);
        System.out.println(menu);
    }
    @Test
    public void listMenuTest(){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        //2是接口，1是菜单，0目录
        queryWrapper.eq("m.type",2);
        queryWrapper.eq("m.path","/user/page");

        List<Menu> menus = menuMapper.listMenu(queryWrapper);
        System.out.println(menus);
    }
}
