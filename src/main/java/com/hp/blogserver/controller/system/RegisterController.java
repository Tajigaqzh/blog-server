package com.hp.blogserver.controller.system;

import com.hp.blogserver.entity.User;
import com.hp.blogserver.utils.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 22:30
 * @Version 1.0
 */
@Tag(name = "登录", description = "登录接口")
@RestController
public class RegisterController {

    public Result register(@RequestBody User user, HttpServletRequest request) {
        return Result.ok();
    }

}
