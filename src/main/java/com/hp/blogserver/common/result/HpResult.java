package com.hp.blogserver.common.result;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/10 6:41
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
public class HpResult<T> implements Serializable {
    private String message;

    private Integer code;

    private T data;

    //成功 并不返回数据
    public static <T> HpResult<T> ok() {
        return new HpResult<T>(StatusCode.SUCCESS.message(), StatusCode.SUCCESS.code(), null);
    }
    //成功 并返回数据
    public static <T> HpResult<T> ok(T data) {
        return new HpResult<T>(StatusCode.SUCCESS.message(), StatusCode.SUCCESS.code(), data);
    }

    //系统错误 不返回数据
    public static <T> HpResult<T> error() {
        return new HpResult<T>(StatusCode.FAILURE.message(), StatusCode.FAILURE.code(), null);
    }

    //系统错误 并返回逻辑数据
    public static <T> HpResult<T> error(T data) {
        return new HpResult<T>(StatusCode.FAILURE.message(), StatusCode.FAILURE.code(), data);
    }

    //错误并返回指定错误信息和状态码以及逻辑数据
    public static <T> HpResult<T> error(StatusCode statusCode, T data) {
        return new HpResult<T>(statusCode.message(), statusCode.code(), data);
    }

    // 错误并返回指定错误信息和状态码 不返回数据
    public static <T> HpResult<T> error(StatusCode statusCode) {
        return new HpResult<T>(statusCode.message(), statusCode.code(), null);
    }

    //自定义错误和状态返回
    public static <T> HpResult<T> errorMessage(String message, Integer code, T data) {
        return new HpResult<T>(message, code, data);
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
