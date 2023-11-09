package com.hp.blogserver.utils;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 17:44
 * @Version 1.0
 */
public enum ResultCode {
    SUCCESS(200, "成功"),
    PARAM_ERROR(400, "参数错误"),
    NAME_PASS_ERROR(402, "用户名或密码错误"),
    NONE_TOKEN(401,"未登录，获取不到token"),
    EXPIRE(403, "无权限"),
    NOTFOUND(404,"未找到"),
    ERROR(500, "失败");




    private Integer code;
    private String message;

    private ResultCode() {
    }

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return message;
    }
}
