package com.hp.blogserver.controller.system;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hp.blogserver.common.PageResult;
import com.hp.blogserver.common.vo.UserVo;
import com.hp.blogserver.entity.User;
import com.hp.blogserver.service.IUserService;
import com.hp.blogserver.utils.JwtUtils;
import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.ResultCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.constraints.Max;
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

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/6 23:30
 * @Version 1.0
 */
@Slf4j
@Tag(name = "用户", description = "用户登录注册相关接口")
@Validated
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;


    //MissingServletRequestParameterException
    //jakarta.validation.ConstraintViolationException: page.pageSize: 最大不能超过20
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
            @RequestParam(name = "currentPage", defaultValue = "1") @NotNull Integer currentPage,
            @RequestParam(name = "pageSize", defaultValue = "10") @NotNull @Max(value = 50, message = "pageSize最大不超过50") Integer pageSize,
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

        return Result.success(PageResult.getInstance(userIPage));
    }

    @Parameters({@Parameter(name = "id", required = true, example = "1", description = "userId")})
    @Operation(summary = "查询用户")
    @GetMapping("/getById")
    public Result getById(@NotNull(message = "id不能为空") Long id) {
        User user = userService.getById(id);
        if (ObjectUtil.isNotNull(user)) {
            user.setPassword(null);
            return Result.success(user);
        }
        return Result.error(null, ResultCode.NOTFOUND);
    }

    @Parameters({@Parameter(name = "token", required = true, description = "旧的token")})
    @Operation(summary = "刷新token", description = "根据旧的token生成新的token,过期时间延迟", method = "post")
    @PostMapping("/rfToken")
    public Result refreshToken(@RequestBody String token) {
        String token1 = JwtUtils.refreshToken(JSONUtil.parse(token).getByPath("token").toString());
        Map<String, Object> data = new HashMap<>();
        data.put("token", token1);
        return Result.success(data);
    }

    @GetMapping("/all")
    public Result getAllUser() {
        List<User> collect = userService.list().stream().map(user -> {
                    user.setPassword(null);
                    return user;
                }
        ).toList();
        return Result.result(ResultCode.SUCCESS, collect);
    }


    @DeleteMapping("/delete")
    public Result remove(@NotNull(message = "id不能为空") @RequestBody UserVo userVo) {
        System.out.println("id" + userVo.getId());
        return Result.ok();
    }

    //TODO 修改密码，批量删除，更新，新增用户，
    @PostMapping("/add")
    public Result addUser() {

        return Result.success();
    }
}
