package com.hp.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/12 17:08
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_menu_perm")
@Schema(description = "菜单-权限")
public class MenuPerm {
    /** 菜单主键ID **/
    @Schema(description = "菜单主键ID")
    @TableField(value = "menu_id")
    private Long menuId;

    /** 权限主键ID **/
    @Schema(description = "权限主键ID")
    @TableField(value = "perm_id")
    private Long permId;
}
