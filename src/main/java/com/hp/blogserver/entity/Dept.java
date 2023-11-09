package com.hp.blogserver.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hp.blogserver.validate.anno.EnumValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Author 20126
 * @Description 部门
 * @Date 2023/11/5 14:47
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_dept")
@Schema(description = "部门")
public class Dept {
    /**
     * 主键id
     **/
    @Schema(description = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 删除状态：0、已删除 1、未删除
     **/
    @Schema(description = "删除状态：0、已删除 1、未删除")
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
     * 部门名称
     **/
    @Schema(description = "部门名称")
    @TableField(value = "dept_name")
    private String deptName;

    /**
     * 显示顺序
     **/
    @Schema(description = "显示顺序")
    @TableField(value = "order_num")
    private Integer orderNum;


    /**
     * 负责人
     **/
    @Schema(description = "负责人")
    @TableField(value = "manager")
    private String manager;

    /**
     * 联系电话
     **/
    @Schema(description = "联系电话")
    @TableField(value = "phone")
    private String phone;

    /**
     * 邮箱
     **/
    @Schema(description = "邮箱")
    @TableField(value = "email")
    private String email;

    /**
     * 部门的状态（0正常 1停用）
     **/
    @Schema(description = "部门状态（0正常 1停用）")
    @EnumValue(intValues = {0, 1})
    @TableField(value = "status")
    private Boolean status;

    /** 创建者 **/
    @Schema(description = "创建者")
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String createBy;


    /** 更新者 **/
    @Schema(description = "更新者")
    @TableField(value = "update_by",fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /** 父部门ID **/
    @Schema(description = "父部门ID")
    @TableField(value = "parent_id")
    private Long parentId;
}
