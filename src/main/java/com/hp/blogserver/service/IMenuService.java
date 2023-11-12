package com.hp.blogserver.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hp.blogserver.common.dto.AuthRolePermDto;
import com.hp.blogserver.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 19:25
 * @Version 1.0
 */


public interface IMenuService extends IService<Menu> {

    List<Menu> listMenu(Wrapper<Menu> wrapper);

    IPage<Menu> listPage(IPage<Menu> page, @Param(Constants.WRAPPER) Wrapper<Menu> queryWrapper);
    boolean saveAuth(AuthRolePermDto menuRolePerm);
}
