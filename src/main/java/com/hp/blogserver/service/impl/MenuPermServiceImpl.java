package com.hp.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.blogserver.entity.MenuPerm;
import com.hp.blogserver.mapper.MenuPermMapper;
import com.hp.blogserver.service.IMenuPermService;
import org.springframework.stereotype.Service;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/12 17:12
 * @Version 1.0
 */
@Service
public class MenuPermServiceImpl extends ServiceImpl<MenuPermMapper, MenuPerm> implements IMenuPermService {
}
