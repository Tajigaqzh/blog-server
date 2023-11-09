package com.hp.blogserver.validate.anno;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.ObjectUtils;

import java.lang.annotation.Documented;
import java.util.regex.Pattern;

/**
 * @Author 20126
 * @Description 自定义正则校验器，默认使用严格模式
 * @Date 2023/11/5 16:20
 * @Version 1.0
 */

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, Object> {
    //严格模式校验规则
    private final String regexStrict = "^(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-79])|(?:5[0-35-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[1589]))\\d{8}$";
    // 非严格模式
    private final String regexSimple = "^(?:(?:\\+|00)86)?1[3-9]\\d{9}$";
    private boolean restrict;

    private String regexPattern;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        if (!"".equals(constraintAnnotation.regexPattern())) {
            regexPattern = constraintAnnotation.regexPattern();
        }
        restrict = constraintAnnotation.restrict();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (ObjectUtils.isEmpty(value)){
            return false;
        }
        if (regexPattern != null ) {
            return Pattern.compile(regexPattern).matcher(value.toString()).find();
        }
        if (restrict) {
            System.out.println(value);
            return Pattern.compile(regexStrict).matcher(value.toString()).find();
        } else {
            return Pattern.compile(regexSimple).matcher(value.toString()).find();
        }
    }
}
