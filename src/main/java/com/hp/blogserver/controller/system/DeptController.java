package com.hp.blogserver.controller.system;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hp.blogserver.common.PageResult;
import com.hp.blogserver.common.dto.DeptDto;
import com.hp.blogserver.entity.Dept;
import com.hp.blogserver.service.IDeptService;
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
 * @Date 2023/11/12 18:53
 * @Version 1.0
 */
@Tag(name = "部门")
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @Parameters({
            @Parameter(name = "currentPage", description = "页码", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "pageSize", description = "每页条数", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "startTime", description = "开始时间：格式yyyy-mm-dd", required = false, in = ParameterIn.QUERY),
            @Parameter(name = "endTime", description = "结束时间：格式yyyy-mm-dd", required = false, in = ParameterIn.QUERY),
    })
    @Operation(summary = "部门分页查询")
    @GetMapping("/page")
    public Result page(
            @RequestParam(name = "currentPage", defaultValue = "1") Long currentPage,
            @RequestParam(name = "pageSize", defaultValue = "10") @Validated @Max(50) Long pageSize,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {

        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("updateTime");

        if (ObjUtil.isNotEmpty(startTime) && ObjUtil.isNotEmpty(endTime)) {
            wrapper.ge("updateTime", startTime);
            wrapper.le("updateTime", endTime);
        }
        IPage<Dept> page = deptService.page(new Page<>(currentPage, pageSize), wrapper);
        PageResult instance = PageResult.getInstance(page);
        return Result.success(instance);
    }

    @Operation(summary = "新增部门", description = "新增部门")
    @PostMapping("/save")
    public Result save(@RequestBody @Validated Dept dept) {
        boolean save = deptService.save(dept);
        if (save) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.INSERT_ERROR);
    }

    @Operation(summary = "更新部门", description = "更新部门")
    @PostMapping("/update")
    public Result update(@RequestBody @Validated(UpdateGroup.class) Dept dept) {
        boolean update = deptService.updateById(dept);
        if (update) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.UPDATE_ERROR);
    }


    @Operation(summary = "删除部门", description = "根据ID删除部门")
    @PostMapping("/delById")
    public Result deleteById(@RequestBody @Validated DeptDto dept) {
        boolean b = deptService.removeById(dept.getDeptId());
        if (b) {
            return Result.ok();
        }
        return Result.error(null, ResultCode.DELETE_ERROR);
    }


    @Operation(summary = "查询部门", description = "根据ID查询部门")
    @GetMapping("/getById")
    public Result getById(@RequestBody @Validated DeptDto dept) {
        Dept byId = deptService.getById(dept.getDeptId());

        if (ObjectUtil.isNotNull(byId)) {
            return Result.success(byId);
        }
        return Result.error(null, ResultCode.QUERY_ERROR);

    }

    @Operation(summary = "查询部门", description = "查询所有部门")
    @GetMapping("/getDeptList")
    public Result getDeptList() {
        return Result.success(deptService.list());
    }


    @Operation(summary = "批量删除", description = "根据ID批量删除部门")
    @PostMapping("/removeBatchByIds")
    public Result removeBatchByIds(@RequestBody @Validated @NotEmpty List<Long> ids) {
        return Result.success(deptService.removeBatchByIds(ids));
    }

}
