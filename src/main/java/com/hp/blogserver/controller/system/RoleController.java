package com.hp.blogserver.controller.system;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hp.blogserver.common.PageResult;
import com.hp.blogserver.entity.Role;
import com.hp.blogserver.service.IRoleService;
import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.ResultCode;
import com.hp.blogserver.validate.AddGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/10 7:06
 * @Version 1.0
 */
@Tag(name = "用户角色")
@RestController
@Validated
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;


    @Parameters({
            @Parameter(name = "currentPage", description = "页码", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "pageSize", description = "每页条数", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "startTime", description = "开始时间：格式yyyy-mm-dd", required = false, in = ParameterIn.QUERY),
            @Parameter(name = "endTime", description = "结束时间：格式yyyy-mm-dd", required = false, in = ParameterIn.QUERY),
    })
    @Operation(summary = "用户角色分页查询")
    @GetMapping("/page")
    public Result page(
            @RequestParam(name = "currentPage", defaultValue = "1") Long currentPage,
            @RequestParam(name = "pageSize", defaultValue = "10") Long pageSize,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime
    ) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("updateTime");
        if (ObjUtil.isNotEmpty(startTime) && ObjUtil.isNotEmpty(endTime)) {
            wrapper.ge("updateTime", startTime);
            wrapper.le("updateTime", endTime);
        }

        IPage<Role> page = roleService.page(new Page<>(currentPage, pageSize), wrapper);
        if (ObjectUtil.isNotNull(page)) {
            return Result.success(PageResult.getInstance(page));
        }
        return Result.error(null, ResultCode.QUERY_ERROR);
    }

    @Operation(summary = "新增用户角色", description = "新增或者更新用户角色")
    @PostMapping("/update")
    public Result saveOrUpdate(@RequestBody Role role) {
        boolean b = roleService.updateById(role);
        if (b) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.UPDATE_ERROR);
    }

    @Operation(summary = "新增", description = "新增角色")
    @PostMapping("/save")
    public Result save(@RequestBody @Validated(AddGroup.class) Role role) {
        boolean save = roleService.save(role);
        if (save) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.INSERT_ERROR);
    }

    @Operation(summary = "删除用户角色", description = "根据ID删除用户角色")
    @PostMapping("/delById")
    public Result deleteById(@RequestBody @Validated Role role) {
        boolean b = roleService.removeById(role);
        if (b) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.DELETE_ERROR);
    }

    @Operation(summary = "查询用户角色", description = "根据ID查询用户角色")
    @GetMapping("/getById")
    public Result getById(Long id) {
        Role byId = roleService.getById(id);
        if (ObjectUtil.isNotNull(byId)) {
            return Result.success(byId);
        }
        return Result.error(null, ResultCode.QUERY_ERROR);
    }

    @Operation(summary = "所有角色", description = "查询所有角色")
    @GetMapping("/getRoleList")
    public Result getRoleList() {
        return Result.success(roleService.list());
    }

    @Operation(summary = "查询role-菜单id", description = "根据菜单ID查询角色")
    @GetMapping("/getSelectedRolesByMenuId")
    public Result getSelectedRolesByMenuId(@Validated @NotNull Long menuId) {
        return Result.ok(roleService.getSelectedRolesByMenuId(menuId));
    }

    @Operation(summary = "查询role-用户id", description = "根据用户ID查询角色")
    @GetMapping("/getSelectedRolesByUserId")
    public Result getSelectedRolesByUserId(@Validated @NotNull Long userId) {
        return Result.ok(roleService.getSelectedRolesByUserId(userId));
    }

    @Operation(summary = "批量删除", description = "根据ID批量删除")
    @PostMapping("/removeBatchByIds")
    public Result removeBatchByIds(@RequestBody @NotEmpty List<Long> ids) {
        return Result.success(roleService.removeBatchByIds(ids));
    }

}
