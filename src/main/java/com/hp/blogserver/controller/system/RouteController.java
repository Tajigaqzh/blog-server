package com.hp.blogserver.controller.system;

import com.hp.blogserver.service.IMenuService;
import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.RouteTools;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/14 22:34
 * @Version 1.0
 */
@Tag(name = "路由")
@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    IMenuService menuService;

    @Autowired
    RouteTools routeTools;


    @Operation(summary = "构建路由",description = "构建路由")
    @GetMapping("/getRoutes")
    public Result getRoutes(){
        return Result.ok(routeTools.buildRouteTree());
    }

}
