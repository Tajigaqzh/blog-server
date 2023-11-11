package com.hp.blogserver.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hp.blogserver.annotation.EnumValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 * @Author 20126
 * @Description 用户实体类
 * @Date 2023/11/5 14:32
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户实体类", title = "用户实体类")
@TableName(value = "sys_user", autoResultMap = true)
public class User implements Serializable, UserDetails {

    /**
     * 主键id
     */
    @Schema(description = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 删除状态：0、已删除 1、未删除
     **/
    @Schema(description = "删除状态：0、已删除 1、未删除")
//    @EnumValue(intValues = {0, 1}, message = "状态只能是0或者1")
    @TableField(value = "deleteStatus")
    private int deleteStatus;


    /**
     * 用户名
     */
    @Schema(description = "用户名", maxLength = 20, minLength = 3)
//    @NotBlank(message = "用户名不能为空")
    @TableField(value = "username")
    private String username;

    /**
     * 昵称
     */
    @Schema(description = "用户昵称", maxLength = 20, minLength = 3)
//    @NotBlank(message = "昵称不能为空")
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 密码
     */
    @Schema(description = "密码", minLength = 10, maxLength = 100)
    @TableField(value = "password")
    private String password;


    /**
     * 开启或者关闭，lombok不生成getter
     */
    @Schema(description = "开启或者关闭")
    @Getter(AccessLevel.NONE)// 不生产Getter，继承的有
    @TableField(value = "enabled")
    private boolean enabled;

    /**
     * 性别：0、女 1、男
     **/
    @Schema(description = "性别：0、女 1、男")
    @EnumValue(intValues = {0, 1}, message = "性别只能是0或者1")
    @TableField(value = "sex")
    private int sex;

    /**
     * 手机号
     **/

    @Schema(description = "手机号", requiredMode = Schema.RequiredMode.REQUIRED)
    @TableField(value = "mobile")
    private String mobile;


    /**
     * 邮箱
     **/
    @Schema(description = "邮箱")
    @TableField(value = "email")
    private String email;

    /**
     * 部门ID
     **/

    @Schema(description = "部门ID")
    @TableField(value = "dept_id")
    private Long deptId;

    /**
     * 所属部门
     **/
    @Schema(description = "所属部门")
    @TableField(exist = false)
    private Dept dept;


    /**
     * 角色列表
     */
    @Schema(hidden = true)
    @TableField(exist = false)
    private List<Role> roles;

    /**
     * 权限列表
     */
    @Schema(hidden = true)
    @TableField(exist = false)
    private List<Permission> permissions;


    /**
     * 创建者
     **/
    @Schema(description = "创建者")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;


    /**
     * 创建时间
     **/
    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private java.util.Date createTime;


    /**
     * 更新者
     **/
    @Schema(description = "更新者")
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;


    /**
     * 更新时间
     **/
    @Schema(description = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "updateTime", fill = FieldFill.UPDATE)
    private Date updateTime;


    /**
     * 权限
     */
    @Setter
    @TableField(exist = false)
    private List<GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
