package com.hp.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hp.blogserver.entity.MenuRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 20126
 * @Description 菜单-角色接口
 * @Date 2023/11/12 17:03
 * @Version 1.0
 */
@Mapper
public interface MenuRoleMapper extends BaseMapper<MenuRole> {
}
