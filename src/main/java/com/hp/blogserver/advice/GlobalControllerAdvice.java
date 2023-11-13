package com.hp.blogserver.advice;

import com.hp.blogserver.exception.UserHasExistException;
import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.ResultCode;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

/**
 * @Author 20126
 * @Description 全局Controller异常拦截器
 * @Date 2023/11/9 6:48
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalControllerAdvice {
    /**
     * 方法参数校验错误
     *
     * @param ex exception
     * @return String
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public String handleException(MethodArgumentNotValidException ex) {
        String[] default_messages = ex.getMessage().split("default message");
        String default_message = default_messages[default_messages.length - 1];
        String trim = default_message.replace("[", "").replace("]", "").trim();
        return Result.errorJSON(null, ResultCode.PARAM_ERROR, trim);
    }

    //TODO resultCode待完善。可以把具体参数失败信息返回，记录日志

    /**
     * 构造参数校验错误
     *
     * @param ex exception
     * @return String
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public String handleConstraintViolationException(ConstraintViolationException ex) {
        return Result.errorJSON(null, ResultCode.PARAM_ERROR, Arrays.stream(ex.getMessage().split(":")).toList().get(1).trim());
    }

    /**
     * 未传参
     *
     * @param exception 异常
     * @return 未传参
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public String handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return Result.errorJSON(ResultCode.PARAM_ERROR);
    }

    /**
     * 方法不支持错误
     *
     * @param exception exception
     * @return String
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public String HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        return Result.errorJSON(ResultCode.UN_SUPPORT_METHOD);
    }

    @ExceptionHandler({UserHasExistException.class})
    public String userHasExist() {
        return Result.errorJSON(ResultCode.INSERT_ERROR);
    }
}
