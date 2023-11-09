package com.hp.blogserver.advice;

import com.hp.blogserver.utils.Result;
import com.hp.blogserver.utils.ResultCode;
import jakarta.validation.ConstraintViolationException;
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
    public void handleException(MethodArgumentNotValidException ex) {
    // System.out.println(ex);
    }

    //TODO resultCode待完善。可以把具体参数失败信息返回
    @ExceptionHandler({ConstraintViolationException.class})
    public String handleConstraintViolationException(ConstraintViolationException ex) {
//        Arrays.stream(ex.getMessage().split(":")).toList().get(1).trim()
        return Result.errorJSON(null, ResultCode.PARAM_ERROR,Arrays.stream(ex.getMessage().split(":")).toList().get(1).trim());
    }
}
