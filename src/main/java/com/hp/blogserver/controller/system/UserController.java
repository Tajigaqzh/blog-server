package com.hp.blogserver.controller.system;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hp.blogserver.common.HpConstant;
import com.hp.blogserver.common.PageResult;
import com.hp.blogserver.common.dto.UserDto;
import com.hp.blogserver.entity.User;
import com.hp.blogserver.service.IUserService;
import com.hp.blogserver.utils.JwtUtils;
import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.ResultCode;
import com.hp.blogserver.validate.AddGroup;
import com.hp.blogserver.validate.UpdateGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/6 23:30
 * @Version 1.0
 */
@Slf4j
@Tag(name = "用户", description = "用户登录注册相关接口")
@RequestMapping("/user")
@RestController
public class UserController {

    //    不涉及事务在controller处理，涉及的话，还是在service层处理
    //TODO 重写一个UserDTO，对字段做出限制，授权
    @Autowired
    IUserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Parameters({
            @Parameter(name = "currentPage", description = "页码", required = true, in = ParameterIn.QUERY, example = "1"),
            @Parameter(name = "pageSize", description = "每页条数", required = true, in = ParameterIn.QUERY, example = "10"),
            @Parameter(name = "startTime", description = "开始时间：格式yyyy-mm-dd", in = ParameterIn.QUERY, example = "2021-10-12"),
            @Parameter(name = "endTime", description = "结束时间：格式yyyy-mm-dd", in = ParameterIn.QUERY, example = "2021-12-22"),
            @Parameter(name = "username", description = "用户名", in = ParameterIn.QUERY, example = "张三"),
            @Parameter(name = "mobile", description = "手机号", in = ParameterIn.QUERY, example = "12345678901"),
            @Parameter(name = "enabled", description = "状态", in = ParameterIn.QUERY, example = "true"),
            @Parameter(name = "deptId", description = "部门id", in = ParameterIn.QUERY, example = "1")
    })
    @Operation(summary = "用户分页查询", description = "分页查询", method = "get")
    @GetMapping("/page")
    public Result page(
            @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(name = "pageSize", defaultValue = "10") @Validated @Max(value = 50, message = "pageSize最大不超过50") Integer pageSize,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime,
            String username,
            String mobile,
            Boolean enabled,
            Long deptId
    ) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("u.createTime");
        // 创建时间条件
        if (ObjectUtil.isNotEmpty(startTime) && ObjUtil.isNotEmpty(endTime)) {
            queryWrapper.ge("u.createTime", startTime);
            queryWrapper.le("u.createTime", endTime);
        }
        if (StrUtil.isNotEmpty(username)) {
            queryWrapper.like("u.username", username.trim());
        }
        if (StrUtil.isNotBlank(mobile)) {
            queryWrapper.eq("u.mobile", mobile);
        }

        if (ObjUtil.isNotNull(enabled)) {
            queryWrapper.eq("u.enabled", enabled);
        }

        if (ObjUtil.isNotNull(deptId)) {
            queryWrapper.eq("u.dept_id", deptId);
        }
        queryWrapper.eq("u.deleteStatus", 1);
        IPage<User> userIPage = userService.listPage(new Page<>(currentPage, pageSize), queryWrapper);

        if (ObjectUtil.isNotNull(userIPage)) {
            return Result.success(PageResult.getInstance(userIPage));
        }
        return Result.error(null, ResultCode.QUERY_ERROR);
    }

    @Parameters({@Parameter(name = "id", required = true, example = "1", description = "userId")})
    @Operation(summary = "查询用户")
    @GetMapping("/getById")
    public Result getById(@NotNull(message = "id不能为空") Long id) {
        User user = userService.getById(id);
        if (ObjectUtil.isNotNull(user)) {
            user.setPassword(HpConstant.decodePass);
            return Result.success(user);
        }
        return Result.error(null, ResultCode.QUERY_ERROR);
    }

    @Parameters({@Parameter(name = "token", required = true, description = "旧的token")})
    @Operation(summary = "刷新token", description = "根据旧的token生成新的token,过期时间延迟", method = "post")
    @PostMapping("/rfToken")
    public Result refreshToken(@RequestBody @NotBlank String token) {
        String token1 = JwtUtils.refreshToken(JSONUtil.parse(token).getByPath("token").toString());
        Map<String, Object> data = new HashMap<>();
        data.put("token", token1);
        return Result.success(data);
    }

    @Operation(summary = "查询所有用户", description = "查询所有用户")
    @GetMapping("/all")
    public Result getAllUser() {
        List<User> list = userService.list();
        if (CollectionUtil.isNotEmpty(list)) {
            for (User user : list) {
                user.setPassword(HpConstant.decodePass);
            }
            return Result.success(list);
        }
        return Result.error(null, ResultCode.QUERY_ERROR);
    }


    @Operation(summary = "删除用户", description = "根据iD删除永华")
    @PostMapping("/delById")
    public Result remove(@RequestBody User user) {
        boolean b = userService.removeById(user.getId());
        if (b) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.DELETE_ERROR);
    }


    @Operation(summary = "新增用户", description = "新增用户")
    @PostMapping("/save")
    public Result save(@RequestBody @Validated(value = {AddGroup.class}) UserDto ua) {
        boolean save = userService.save(ua);
        if (save) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.INSERT_ERROR);
    }

    @Operation(summary = "更新用户", description = "更新用户")
    @PostMapping("/update")
    public Result update(@RequestBody @Validated(value = {UpdateGroup.class}) UserDto ua) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", ua.getId());
        boolean updateUser = userService.update(ua, updateWrapper);
        if (updateUser) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.UPDATE_ERROR);
    }

    @Operation(summary = "批量删除", description = "根据id批量删除")
    @PostMapping("/removeBatchByIds")
    public Result removeBatchByIds(@RequestBody List<Long> ids) {
        int i = userService.deleteBatchByIds(ids);
        if (i > 0) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.DELETE_ERROR);
    }

    @Operation(summary = "重置初始化密码", description = "重置密码")
    @PostMapping("/ReSetPassword")
    public Result resetPassword(@RequestBody User user) {
        String username = user.getUsername();
        String substring = user.getUsername().substring(username.length() - 4, username.length());

        String encode = passwordEncoder.encode(substring);
        boolean update = userService.update(new UpdateWrapper<User>().set("password", encode).eq("id", user.getId()));
        if (update) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.OTHER_ERROR);
    }
}
