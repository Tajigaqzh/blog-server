package com.hp.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hp.blogserver.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/6 22:45
 * @Version 1.0
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    /**
     * 根据uid查询部门
     *
     * @param userId userid
     * @return Dept
     */
    Dept getDeptByUserId(@Param("userId") Long userId);
}
