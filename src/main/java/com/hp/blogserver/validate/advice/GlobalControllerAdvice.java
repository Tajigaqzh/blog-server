//package com.hp.blogserver.validate.advice;
//
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.ConstraintViolationException;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.net.BindException;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
///**
// * @Author 20126
// * @Description
// * @Date 2023/11/5 14:55
// * @Version 1.0
// */
//@RestControllerAdvice
//public class GlobalControllerAdvice {
////    private static final String BAD_REQUEST_MSG = "客户端请求参数错误";
////    // <1> 处理 form data方式调用接口校验失败抛出的异常
////    @ExceptionHandler(BindException.class)
////    public ResultInfo bindExceptionHandler(BindException e) {
////        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
////        List<String> collect = fieldErrors.stream()
////                .map(o -> o.getDefaultMessage())
////                .collect(Collectors.toList());
////        return new ResultInfo().success(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST_MSG, collect);
////    }
////    // <2> 处理 json 请求体调用接口校验失败抛出的异常
////    @ExceptionHandler(MethodArgumentNotValidException.class)
////    public ResultInfo methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
////        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
////        List<String> collect = fieldErrors.stream()
////                .map(o -> o.getDefaultMessage())
////                .collect(Collectors.toList());
////        return new ResultInfo().success(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST_MSG, collect);
////    }
////    // <3> 处理单个参数校验失败抛出的异常
////    @ExceptionHandler(ConstraintViolationException.class)
////    public ResultInfo constraintViolationExceptionHandler(ConstraintViolationException e) {
////        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
////        List<String> collect = constraintViolations.stream()
////                .map(o -> o.getMessage())
////                .collect(Collectors.toList());
////        return new ResultInfo().success(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST_MSG, collect);
////    }
//
//}
