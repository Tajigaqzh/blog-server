package com.hp.blogserver.common.result;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/10 6:44
 * @Version 1.0
 */
public enum StatusCode {
    //区分与http状态码
    SUCCESS(200, "操作成功"),
    PARAM_ERROR(400, "参数异常"),
    NOT_FOUND(404, "资源不存在"),
    FAILURE(500, "系统异常"),
    NEED_LOGIN(5002, "需要登录"),
    CUSTOM_FAILURE(501, "自定义异常错误");
    private final Integer code;

    private final String message;

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    //获取状态码
    public Integer code() {
        return code;
    }

    //获取信息
    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }
}
