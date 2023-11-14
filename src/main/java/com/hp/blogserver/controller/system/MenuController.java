package com.hp.blogserver.controller.system;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hp.blogserver.common.PageResult;
import com.hp.blogserver.common.dto.AuthRolePermDto;
import com.hp.blogserver.entity.Menu;
import com.hp.blogserver.service.IMenuService;
import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.ResultCode;
import com.hp.blogserver.validate.UpdateGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/12 15:14
 * @Version 1.0
 */
@Tag(name = "菜单")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    IMenuService menuService;


    @Parameters({
            @Parameter(name = "currentPage", description = "页码", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "pageSize", description = "每页条数", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "startTime", description = "开始时间：格式yyyy-mm-dd", required = false, in = ParameterIn.QUERY),
            @Parameter(name = "endTime", description = "结束时间：格式yyyy-mm-dd", required = false, in = ParameterIn.QUERY),
            @Parameter(name = "parentId", description = "父菜单", required = false, in = ParameterIn.QUERY),
    })
    @Operation(summary = "菜单分页查询")
    @GetMapping("/page")
    public Result page(
            @RequestParam(name = "currentPage", defaultValue = "1") Long currentPage,
            @RequestParam(name = "pageSize", defaultValue = "10") @Validated @Max(50) Long pageSize,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime,
            Long parentId) {

        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("m.updateTime");
        wrapper.eq("m.deleteStatus", 1);
        if (ObjUtil.isNotEmpty(startTime) && ObjUtil.isNotEmpty(endTime)) {
            wrapper.ge("m.updateTime", startTime);
            wrapper.le("m.updateTime", endTime);
        }

        if (ObjUtil.isNotNull(parentId)) {
            wrapper.eq("m.parent_id", parentId);
        }
        IPage<Menu> menuIPage = menuService.listPage(new Page<>(currentPage, pageSize), wrapper);
        PageResult instance = PageResult.getInstance(menuIPage);
        return Result.success(instance);
    }

    @PostMapping("/delById")
    @Operation(summary = "删除菜单", description = "根据ID删除菜单")
    public Result deleteById(@Validated @RequestBody Menu menu) {
        boolean b = menuService.removeById(menu);
        if (b) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.DELETE_ERROR);
    }

    @Operation(summary = "批量删除", description = "根据ID批量删除菜单")
    @PostMapping("/removeBatchByIds")
    public Result removeBatchByIds(@RequestBody List<Long> ids) {
        return Result.success(menuService.removeBatchByIds(ids));
    }

    @Operation(summary = "新增菜单", description = "新增或者更新菜单")
    @PostMapping("/save")
    public Result save(@RequestBody @Validated Menu menu) {
        return Result.success(menuService.saveOrUpdate(menu));
    }

    @Operation(summary = "新增菜单", description = "新增或者更新菜单")
    @PostMapping("/update")
    public Result update(@RequestBody @Validated(UpdateGroup.class) Menu menu) {
        boolean b = menuService.updateById(menu);
        if (b) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.UPDATE_ERROR);
    }

    @Operation(summary = "查询菜单", description = "根据ID查询菜单")
    @GetMapping("/getById")
    public Result getById(Long id) {
        return Result.success(menuService.getById(id));
    }

    @Parameters({
            @Parameter(name = "type", description = "菜单类型", required = false, in = ParameterIn.QUERY),
            @Parameter(name = "pageSize", description = "每页条数", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "startTime", description = "开始时间：格式yyyy-mm-dd", required = false, in = ParameterIn.QUERY),
            @Parameter(name = "endTime", description = "结束时间：格式yyyy-mm-dd", required = false, in = ParameterIn.QUERY),
            @Parameter(name = "parendId", description = "父菜单", required = false, in = ParameterIn.QUERY),
    })
    @Operation(summary = "查询菜单", description = "查询所有菜单")
    @GetMapping("/getMenuList")
    public Result getMenuList(
            @Validated @NotBlank(message = "不能为空") String types,
            Long parentId,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime

    ) {
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotEmpty(startTime) && ObjectUtil.isNotEmpty(endTime)) {
            menuQueryWrapper.ge("m.updateTime", startTime);
            menuQueryWrapper.le("m.updateTime", endTime);
        }

        menuQueryWrapper.in("type", (Object) types.split(","));

        if (parentId != null) {
            menuQueryWrapper.eq("parentId", parentId);
        }
        List<Menu> list = menuService.list(menuQueryWrapper);

        Menu menu = Menu.builder().id(0L).title("顶级菜单").build();

        list.add(0, menu);
        return Result.success(list);
    }

    @Operation(summary = "菜单授权", description = "菜单授权")
    @PostMapping("/saveAuth")
    public Result saveAuth(@RequestBody AuthRolePermDto menuRolePerm) {
        if (ObjectUtil.isNotNull(menuRolePerm)) {
            menuService.saveAuth(menuRolePerm);
            return Result.ok();
        }
        return Result.error(null, ResultCode.UPDATE_ERROR);
    }

}
