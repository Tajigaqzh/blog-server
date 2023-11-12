package com.hp.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/12 17:17
 * @Version 1.0
 */
@Data
@TableName(value = "sys_user_role")
@Schema(description = "用户-角色")
public class UserRole {
    /** 用户主键ID **/
    @Schema(description = "用户主键ID")
    @TableField(value = "user_id")
    private Long userId;

    /** 角色主键ID **/
    @Schema(description = "角色主键ID")
    @TableField(value = "role_id")
    private Long roleId;

}
