package com.hp.blogserver.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hp.blogserver.entity.Menu;
import com.hp.blogserver.entity.Permission;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 16:36
 * @Version 1.0 权限服务层
 */

public interface IPermService extends IService<Permission> {

    /**
     * 根据permission查询menu
     * @param page menu
     * @param queryWrapper 查询条件
     * @return IPage<Permission>
     */
    IPage<Permission> listPage(IPage<Menu> page, @Param(Constants.WRAPPER) Wrapper<Permission> queryWrapper);
}
