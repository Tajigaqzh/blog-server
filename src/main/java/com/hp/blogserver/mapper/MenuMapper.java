package com.hp.blogserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hp.blogserver.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 18:04
 * @Version 1.0
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据条件查询Menu
     * @param wrapper 条件
     * @return List<Menu>
     */
    List<Menu> listMenu(@Param(Constants.WRAPPER) Wrapper<Menu> wrapper);

    /**
     * 根据父id查询menu
     * @param pid pid
     * @return Menu
     */
    Menu selectByParentId(@Param("pid") Long pid);

    IPage<Menu> listPage(IPage<Menu> page,@Param(Constants.WRAPPER) Wrapper<Menu> queryWrapper);

}
