package com.hp.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hp.blogserver.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/6 22:54
 * @Version 1.0
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据userId查询role
     *
     * @param userId uid
     * @return List<Role>
     */
    List<Role> getRolesByUserId(@Param(value = "userId") Long userId);

    /**
     * 根据menuId查询role
     *
     * @param menuId 菜单id
     * @return List<Role>
     */
    List<Role> getSelectedRolesByMenuId(@Param(value = "menuId") Long menuId);
}
