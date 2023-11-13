package com.hp.blogserver.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hp.blogserver.entity.User;
import com.hp.blogserver.service.IUserRoleService;
import com.hp.blogserver.service.IUserService;
import com.hp.blogserver.utils.Asserts;
import com.hp.blogserver.utils.Result;
import com.hp.blogserver.validate.AddGroup;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Result register(@Validated(value = AddGroup.class) @RequestBody User user) {
        User queryUser = userService.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        Asserts.exist(queryUser);

        String encode = passwordEncoder.encode(user.getPassword());
        System.out.println(encode);

        user.setPassword(encode);
        user.setEnabled(true);




        return Result.ok();
    }

}
