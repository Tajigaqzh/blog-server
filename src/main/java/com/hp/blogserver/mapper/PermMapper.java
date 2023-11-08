package com.hp.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
     * @param menuId menuId
     * @return List<Permission>
     */
    List<Permission> getSelectedPermsByMenuId(@Param(value = "menuId") Long menuId);
}
