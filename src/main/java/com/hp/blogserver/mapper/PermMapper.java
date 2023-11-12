package com.hp.blogserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hp.blogserver.entity.Menu;
import com.hp.blogserver.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/8 21:29
 * @Version 1.0
 */
@Mapper
public interface PermMapper extends BaseMapper<Permission> {
    /**
     * 根据menuId查询权限
     *
     * @param menuId menuId
     * @return List<Permission>
     */
    List<Permission> getSelectedPermissionByMenuId(@Param(value = "menuId") Long menuId);


    List<Permission> getPermissionByUserId(@Param(value = "userId") Long userId);


    /**
     * 根据条件分页查询权限
     *
     * @param page         page
     * @param queryWrapper 查询条件
     * @return IPage<Permission>
     */
    IPage<Permission> listPage(IPage<Menu> page, @Param(Constants.WRAPPER) Wrapper<Permission> queryWrapper);


}
