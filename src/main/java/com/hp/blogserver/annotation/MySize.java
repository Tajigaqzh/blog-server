package com.hp.blogserver.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 12:37
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {MySizeValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface MySize {

    String message() default "验证失败";

    int maxLength() default Integer.MAX_VALUE;

    int minLength() default 0;

    // 分组
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        MySize[] value();
    }
}
