package com.hp.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 20126
 * @Description 用户权限
 * @Date 2023/11/5 14:33
 * @Version 1.0
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户权限")
@TableName(value = "sys_user_permission")
public class UserPerm {
    /**
     * 用户主键id
     */
    @Schema(description = "用户主键id")
    @TableField(value = "user_id")
    private Long userId;
    /**
     * 权限主键id
     */
    @Schema(description = "权限主键id")
    @TableField(value = "perm_id")
    private Long permId;
}
