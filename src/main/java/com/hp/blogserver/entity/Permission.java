package com.hp.blogserver.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 14:47
 * @Version 1.0
 */
@Data
@TableName(value = "sys_permission")
@Schema(description = "用户权限")
public class Permission {
    /** 主键ID **/
    @Schema(description = "主键ID")
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /** 删除状态：0、已删除 1、未删除 **/
    @Schema(description = "删除状态：0、已删除 1、未删除")
    @TableField(value = "deleteStatus")
    private int deleteStatus;

    /** 创建时间 **/
    @Schema(description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private java.util.Date createTime;

    /** 更新时间 **/
    @Schema(description = "更新时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private java.util.Date updateTime;

    /** 权限名称 **/
    @Schema(description = "权限名称")
    @TableField(value = "name")
    private String name;

    /** 权限标签 **/
    @Schema(description = "权限标签")
    @TableField(value = "tag")
    private String tag;

    /** 创建者 **/
    @Schema(description = "创建者")
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String createBy;

    /** 更新者 **/
    @Schema(description = "更新者")
    @TableField(value = "update_by",fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /** 备注 **/
    @Schema(description = "备注")
    @TableField(value = "remark")
    private String remark;

    /** 所属菜单 **/
    @Schema(description = "所属菜单")
    @TableField(value = "menu_id")
    private Long menuId;

    /** 所属菜单 **/
    @Schema(description = "所属菜单")
    @TableField(exist = false)
    private Menu menu;
}
