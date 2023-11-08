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

    public static Result result(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.code = resultCode.getCode();
        result.data = data;
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        ResultCode resultCode = ResultCode.SUCCESS;
        result.code = resultCode.getCode();
        result.data = data;
        return result;
    }

    public static Result success() {
        return success("ok");
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
        return success("ok");
    }

    public static Result error(Object data) {
        Result result = new Result();
        ResultCode resultCode = ResultCode.ERROR;
        result.code = resultCode.getCode();
        result.data = data;
        return result;
    }

    public static Result error(Object data, ResultCode resultCode) {
        Result result = new Result();
        result.code = resultCode.getCode();
        result.data = data;
        result.message = resultCode.getMsg();
        return result;
    }

    public static String errorJSON(Object result) {
        return JSONUtil.toJsonStr(error(result));
    }

    public static String errorJSON(Object data, ResultCode resultCode) {
        return JSONUtil.toJsonStr(error(data, resultCode));
    }
}
