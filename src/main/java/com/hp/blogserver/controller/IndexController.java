package com.hp.blogserver.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/7 21:04
 * @Version 1.0
 */
@Tag(name = "icon")
@RestController
public class IndexController {

    @GetMapping("/favicon.ico")
    public void favicon(){

    }
}
