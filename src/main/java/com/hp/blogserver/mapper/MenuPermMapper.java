package com.hp.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hp.blogserver.entity.MenuPerm;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 20126
 * @Description 菜单-权限 Mapper 接口
 * @Date 2023/11/12 17:09
 * @Version 1.0
 */
@Mapper
public interface MenuPermMapper extends BaseMapper<MenuPerm> {

}
