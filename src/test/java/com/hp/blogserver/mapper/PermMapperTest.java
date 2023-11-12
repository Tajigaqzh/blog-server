package com.hp.blogserver.mapper;

import com.hp.blogserver.entity.Permission;
import org.apache.bcel.generic.PUSH;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/8 22:00
 * @Version 1.0
 */
@SpringBootTest
public class PermMapperTest {
    @Autowired
    private PermMapper permMapper;

    @Test
    public void getSelectedPermsByMenuIdTest(){
        List<Permission> selectedPermsByMenuId = permMapper.getSelectedPermissionByMenuId(3L);
        System.out.println(selectedPermsByMenuId);
    }

    @Test
    public void getPermissionByUserIdTest(){
        List<Permission> permissionByUserId = permMapper.getPermissionByUserId(203L);
        System.out.println(permissionByUserId);
    }

    @Test
    public void getSelectedPermissionByMenuIdTest(){
        List<Permission> selectedPermissionByMenuId = permMapper.getSelectedPermissionByMenuId(3L);
        System.out.println(selectedPermissionByMenuId);
    }
}
