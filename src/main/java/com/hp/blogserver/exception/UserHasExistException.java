package com.hp.blogserver.exception;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/13 22:13
 * @Version 1.0
 */

public class UserHasExistException extends RuntimeException {
    @Override
    public String getMessage() {
        return "用户已存在";
    }

    public UserHasExistException() {
        super();
    }
}
