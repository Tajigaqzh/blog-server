package com.hp.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.blogserver.entity.UserPerm;
import com.hp.blogserver.mapper.UserPermMapper;
import com.hp.blogserver.service.IUserPermService;
import org.springframework.stereotype.Service;

/**
 * @Author 20126
 * @Description 用户-权限 实现类
 * @Date 2023/11/12 17:12
 * @Version 1.0
 */
@Service
public class UserPermServiceImpl extends ServiceImpl<UserPermMapper, UserPerm> implements IUserPermService {

}
