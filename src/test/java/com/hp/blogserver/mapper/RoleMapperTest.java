package com.hp.blogserver.mapper;

import com.hp.blogserver.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/8 21:08
 * @Version 1.0
 */
@SpringBootTest
public class RoleMapperTest {
    @Autowired
    RoleMapper roleMapper;


    @Test
    public void testGetRolesByUserId(){
        List<Role> rolesByUserId = roleMapper.getRolesByUserId(1L);
        System.out.println(rolesByUserId);
    }

    @Test
    public void testGetSelectedRolesByMenuId(){
        List<Role> selectedRolesByMenuId = roleMapper.getSelectedRolesByMenuId(1L);
        System.out.println(selectedRolesByMenuId);
    }
}
