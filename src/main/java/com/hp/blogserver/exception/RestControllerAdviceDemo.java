//package com.hp.blogserver.exception;
//
//import com.hp.blogserver.utils.Result;
//import com.hp.blogserver.utils.ResultCode;
//import jakarta.validation.ConstraintViolationException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.Arrays;
//
///**
// * @Author 20126
// * @Description
// * @Date 2023/11/8 23:00
// * @Version 1.0
// */
//@RestControllerAdvice
//public class RestControllerAdviceDemo {
//
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    public void handleException(MethodArgumentNotValidException ex) {
////        System.out.println(ex);
//    }
//
//    @ExceptionHandler({ConstraintViolationException.class})
//    public String handleConstraintViolationException(ConstraintViolationException ex) {
//
//        return Result.errorJSON(null,ResultCode.PARAM_ERROR);
////        return Result.errorJSON(Arrays.stream(ex.getMessage().split(":")).toList().get(1).trim(), ResultCode.PARAM_ERROR);
//    }
//}
