package com.hp.blogserver.advice;

import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.ResultCode;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/9 6:48
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public String handleException(MethodArgumentNotValidException ex) {
        String[] default_messages = ex.getMessage().split("default message");

        String default_message = default_messages[default_messages.length - 1];
        String trim = default_message.replace("[", "").replace("]", "").trim();

        return Result.errorJSON(null, ResultCode.PARAM_ERROR,trim);
    }

    //TODO resultCode待完善。可以把具体参数失败信息返回，记录日志

    /**
     * 参数校验错误
     * @param ex
     * @return
     */

    @ExceptionHandler({ConstraintViolationException.class})
    public String handleConstraintViolationException(ConstraintViolationException ex) {
//        Arrays.stream(ex.getMessage().split(":")).toList().get(1).trim()
        System.out.println(ex);
        System.out.println("----------------------");
        return Result.errorJSON(null, ResultCode.PARAM_ERROR, Arrays.stream(ex.getMessage().split(":")).toList().get(1).trim());
    }

    /**
     * 未传参
     * @param exception
     * @return
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public String handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return Result.errorJSON(null, ResultCode.PARAM_ERROR);
    }
}
