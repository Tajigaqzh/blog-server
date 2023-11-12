package com.hp.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.blogserver.entity.Dept;
import com.hp.blogserver.mapper.DeptMapper;
import com.hp.blogserver.service.IDeptService;
import org.springframework.stereotype.Service;

/**
 * @Author 20126
 * @Description 部门实现类
 * @Date 2023/11/12 18:54
 * @Version 1.0
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
