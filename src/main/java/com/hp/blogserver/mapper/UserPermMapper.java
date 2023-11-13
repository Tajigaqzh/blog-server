package com.hp.blogserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hp.blogserver.entity.UserPerm;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/14 7:17
 * @Version 1.0
 */
@Mapper
public interface UserPermMapper extends BaseMapper<UserPerm> {
}
