package com.hp.blogserver.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 12:43
 * @Version 1.0
 */
public class MySizeValidator implements ConstraintValidator<MySize, Object> {
    private int maxLength;
    private int minLength;

    @Override
    public void initialize(MySize constraintAnnotation) {
        maxLength = constraintAnnotation.maxLength();
        minLength = constraintAnnotation.minLength();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof String) {
            int length = ((String) value).length();
            return length > minLength && (length < maxLength);
        }
        if (value instanceof Long) {
            String s = String.valueOf(value);
            return s.length() > minLength && s.length() < maxLength;
        }
        if (value instanceof Integer) {
            String s = String.valueOf(value);
            return s.length() > minLength && s.length() < maxLength;
        }
        return false;
    }
}
