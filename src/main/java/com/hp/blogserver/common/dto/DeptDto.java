package com.hp.blogserver.common.dto;

import com.hp.blogserver.common.PageResult;
import com.hp.blogserver.entity.Dept;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/12 19:33
 * @Version 1.0
 */

@Data
public class DeptDto {
    @NotNull(message = "deptId不为空")
    private Long deptId;
}
