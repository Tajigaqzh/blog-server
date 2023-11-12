package com.hp.blogserver.common.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/12 17:47
 * @Version 1.0
 */
@Data
public class AuthRolePermDto {

    private Long id;
    private List<Long> roles;

    private List<Long> perms;
}
