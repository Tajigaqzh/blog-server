package com.hp.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/12 17:01
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "菜单-角色")
@TableName("sys_menu_role")
public class MenuRole {
    /** 菜单主键ID **/
    @Schema(description = "菜单主键ID")
    @TableField(value = "menu_id")
    private Long menuId;

    /** 角色主键ID **/
    @Schema(description = "角色主键ID")
    @TableField(value = "role_id")
    private Long roleId;
}
