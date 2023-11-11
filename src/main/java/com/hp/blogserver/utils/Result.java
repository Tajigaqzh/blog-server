package com.hp.blogserver.utils;

import cn.hutool.json.JSONUtil;
import lombok.Data;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 17:43
 * @Version 1.0
 */
@Data
public class Result {
    private Integer code;

    private Object data;

    private String message;


    public static Result success(Object data) {
        Result result = new Result();
        ResultCode resultCode = ResultCode.SUCCESS;
        result.message = resultCode.getMsg();
        result.code = resultCode.getCode();
        result.data = data;
        return result;
    }


    public static String okJSON(Object data) {
        return JSONUtil.toJsonStr(success(data));
    }

    public static String okJSON() {
        return JSONUtil.toJsonStr(ok());
    }

    public static Result ok(Object data) {
        return success(data);
    }

    public static Result ok() {
        return success(null);
    }


    public static Result error(Object data, ResultCode resultCode) {
        Result result = new Result();
        result.code = resultCode.getCode();
        result.data = data;
        result.message = resultCode.getMsg();
        return result;
    }

    public static Result error(Object data, ResultCode resultCode, String errorMessage) {
        Result result = new Result();
        result.code = resultCode.getCode();
        result.data = data;
        result.message = errorMessage;
        return result;
    }


    public static String errorJSON(ResultCode resultCode) {
        return JSONUtil.toJsonStr(error(null, resultCode));
    }

    public static String errorJSON(Object data, ResultCode resultCode) {
        return JSONUtil.toJsonStr(error(data, resultCode));
    }

    public static String errorJSON(Object data, ResultCode resultCode, String message) {
        return JSONUtil.toJsonStr(error(data, resultCode, message));
    }
}
