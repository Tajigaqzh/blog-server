package com.hp.blogserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/7 21:04
 * @Version 1.0
 */
@RestController
public class IndexController {

    @GetMapping("/favicon.ico")
    public void favicon(){

    }
}
