package com.hp.blogserver.controller.system;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hp.blogserver.common.PageResult;
import com.hp.blogserver.common.vo.MenuPermTreeVO;
import com.hp.blogserver.entity.Permission;
import com.hp.blogserver.service.IPermService;
import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.ResultCode;
import com.hp.blogserver.validate.UpdateGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.activiti.engine.impl.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/10 7:05
 * @Version 1.0
 */
@Tag(name = "用户权限")
@RestController
@RequestMapping("/perm")
public class PermController {

    @Autowired
    private IPermService permService;

    @Autowired
    private AuthTools authTools;

    @Parameters({
            @Parameter(name = "currentPage", description = "页码", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "pageSize", description = "每页条数", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "startTime", description = "开始时间：格式yyyy-mm-dd", in = ParameterIn.QUERY),
            @Parameter(name = "endTime", description = "结束时间：格式yyyy-mm-dd", in = ParameterIn.QUERY),
    })
    @Operation(description = "分页查询", summary = "分页查询")
    @GetMapping("/page")
    public Result page(
            @RequestParam(name = "currentPage", defaultValue = "1") Long currentPage,
            @RequestParam(name = "pageSize", defaultValue = "10") Long pageSize,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime
    ) {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();

        if (ObjectUtil.isNotEmpty(startTime) && ObjectUtil.isNotEmpty(endTime)) {
            wrapper.ge("m.updateTime", startTime);
            wrapper.le("m.updateTime", endTime);
        }

        wrapper.eq("p.deleteStatus", 1);
        wrapper.orderByDesc("p.updateTime");

        IPage<Permission> permissionIPage = permService.listPage(new Page<>(currentPage, pageSize), wrapper);
        PageResult instance = PageResult.getInstance(permissionIPage);
        return Result.success(instance);
    }


    @Operation(summary = "查询用户权限", description = "根据ID查询用户权限")
    @GetMapping("/getById")
    public Result getById(@Validated @NotNull Long id) {
        Permission byId = permService.getById(id);
        if (ObjectUtil.isNull(byId)) {
            return Result.success(permService.getById(id));
        }
        return Result.error(null, ResultCode.QUERY_ERROR);
    }

    @Operation(summary = "删除权限", description = "根据ID删除权限")
    @PostMapping("/delById")
    public Result deleteById(@RequestBody Permission permission) {
        boolean b = permService.removeById(permission);
        if (b) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.DELETE_ERROR);
    }

    @Operation(summary = "查询所有权限",description = "查询所有权限")
    @GetMapping("/getPermList")
    public Result getAllPermission() {
        List<MenuPermTreeVO> menus = authTools.getMenus();
        if (CollectionUtil.isNotEmpty(menus)) {
            return Result.success(menus);
        }
        return Result.error(null, ResultCode.QUERY_ERROR);
    }

    @Operation(summary = "查询权限-菜单id", description = "根据菜单ID查询权限")
    @GetMapping("/getSelectedPermsByMenuId")
    public Result getSelectedPermsByMenuId(@Validated @NotNull Long menuId) {
        return Result.ok(permService.getSelectedPermissionByMenuId(menuId));
    }

    @Operation(summary = "查询权限-用户id", description = "根据用户ID查询权限")
    @GetMapping("/getSelectedPermsByUserId")
    public Result getSelectedPermsByUserId(@Validated @NotNull Long userId) {
        return Result.ok(permService.getSelectedPermissionByUserId(userId));
    }

    @Operation(summary = "批量删除", description = "根据ID批量删除")
    @PostMapping("/removeBatchByIds")
    public Result removeBatchByIds(@RequestBody @Validated @NotEmpty List<Long> ids) {
        return Result.success(permService.removeBatchByIds(ids));
    }

    @Operation(summary = "新增用户权限", description = "新增用户权限")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody Permission permission) {
        boolean save = permService.save(permission);
        if (save) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.INSERT_ERROR);
    }

    @Operation(summary = "更新权限", description = "更新权限")
    @PostMapping("/update")
    public Result update(@Validated(UpdateGroup.class) @RequestBody Permission permission) {
        UpdateWrapper<Permission> objectUpdateWrapper = new UpdateWrapper<>();
        objectUpdateWrapper.eq("id", permission.getId());
        boolean update = permService.update(permission, objectUpdateWrapper);
        if (update) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.UPDATE_ERROR);
    }
}
