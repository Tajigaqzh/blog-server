package com.hp.blogserver.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hp.blogserver.annotation.EnumValue;
import com.hp.blogserver.annotation.MySize;
import com.hp.blogserver.annotation.PhoneNumber;
import com.hp.blogserver.entity.User;
import com.hp.blogserver.validate.AddGroup;
import com.hp.blogserver.validate.UpdateGroup;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/10 6:17
 * @Version 1.0
 */

@Data
public class UserDto extends User {

    @NotNull(groups = UpdateGroup.class, message = "id不能为空")
    private Long id;

    @EnumValue(intValues = {1, 0}, message = "deleteStatus状态只能是0,1")
    private int deleteStatus;
    //
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    //
//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Length(min = 1, max = 5, message = "用户名不能为空")
    @NotBlank
    private String username;
    //
    @Length(min = 5, max = 30, message = "nickname格式不正确")
    @NotBlank(message = "nickname格式不正确")
    private String nickname;
    //
    @Length(min = 1, max = 5)
    @NotBlank
    private String password;
//
//

    private boolean enabled;
    //
//
//    groups = {UpdateGroup.class, AddGroup.class}
    @EnumValue(intValues = {1, 0}, message = "sex格式不正确")
    private int sex;
    //
    @PhoneNumber
    private String mobile;
    //


    @Email(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")
    private String email;


    @NotNull(message = "部门id不能为空")
    private Long deptId;
    //
    private String createBy;

    private String updateBy;

}
