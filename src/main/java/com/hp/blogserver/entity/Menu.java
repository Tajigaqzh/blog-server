package com.hp.blogserver.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hp.blogserver.validate.anno.EnumValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 18:03
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_menu", autoResultMap = true)
@Schema(description = "菜单")
public class Menu {

    /**
     * 主键ID
     **/
    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 删除状态：0、已删除 1、未删除
     **/
    @Schema(description = "删除状态：0、已删除 1、未删除")
    @EnumValue(intValues = {1, 0})
    @TableField(value = "deleteStatus")
    private int deleteStatus;

    /**
     * 创建时间
     **/
    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private java.util.Date createTime;

    /**
     * 更新时间
     **/
    @Schema(description = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private java.util.Date updateTime;

    /**
     * 菜单名称
     **/

    @NotBlank
    @Schema(description = "菜单名称")
    @TableField(value = "name")
    private String name;

    /**
     * 菜单地址
     **/
    @NotBlank
    @Schema(description = "菜单地址")
    @TableField(value = "path")
    private String path;

    /**
     * 组件名:如果不填,默认就是菜单路径,从前端src目录开始计算,例如:src/views/ads/index.vue
     **/
    @Schema(description = "组件名:如果不填,默认就是菜单路径,从前端src目录开始计算,例如:src/views/ads/index.vue")
    @TableField(value = "component")
    private String component;

    /**
     * 标题
     **/
    @NotBlank
    @Schema(description = "标题")
    @TableField(value = "title")
    private String title;

    /**
     * 类型：0、目录 1、菜单 2、接口
     **/
    @EnumValue(intValues = {1, 0, 2})
    @Schema(description = "类型：0、目录 1、菜单 2、接口")
    @TableField(value = "type")
    private Integer type;

    /**
     * 图标
     **/
    @Schema(description = "图标")
    @TableField(value = "icon")
    private String icon;

    /**
     * 链接
     **/
    @Schema(description = "链接")
    @TableField(value = "showLink")
    private Boolean showLink;

    /**
     * 排序:值越小越靠前
     **/
    @Schema(description = "排序:值越小越靠前")
    @TableField(value = "`rank`")
    private Integer rank;

    @Schema(hidden = true)
    @TableField(exist = false)
    private List<Role> roles;

    @Schema(hidden = true)
    @TableField(exist = false)
    private List<Permission> perms;

    /**
     * 父菜单
     **/
    @NotNull
    @Schema(description = "父菜单")
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 父菜单
     **/

    @Schema(description = "父菜单")
    @TableField(exist = false)
    private Menu parent;

    /**
     * 创建者
     **/
    @Schema(description = "创建者")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 更新者
     **/
    @Schema(description = "更新者")
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
}