package com.hp.blogserver.mapper;

import com.hp.blogserver.entity.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeptMapperTest {

    @Autowired
    private DeptMapper deptMapper;


    @Test
    public void getDeptByUserIdTest(){
        Dept dept = deptMapper.getDeptByUserId(1L);
        System.out.println(dept);
    }
}
