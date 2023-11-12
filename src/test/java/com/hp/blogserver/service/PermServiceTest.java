package com.hp.blogserver.service;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hp.blogserver.entity.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 20:35
 * @Version 1.0
 */
@SpringBootTest
public class PermServiceTest {
    @Autowired
    private IPermService permService;

    @Test
    public void testPage() {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.eq("p.deleteStatus", 1);
        wrapper.orderByDesc("p.updateTime");

        IPage<Permission> permissionIPage = permService.listPage(new Page<>(1, 10), wrapper);
        System.out.println(permissionIPage.getTotal());
        List<Permission> records = permissionIPage.getRecords();
        ArrayList<Permission> permissions = new ArrayList<>(records);
        for (Permission permission : permissions) {
            System.out.println(permission.getMenu());
        }

    }

    public void add(){

    }
}
