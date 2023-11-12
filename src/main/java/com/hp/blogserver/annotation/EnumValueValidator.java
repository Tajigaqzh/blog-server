package com.hp.blogserver.annotation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 15:21
 * @Version 1.0
 */
public class EnumValueValidator implements ConstraintValidator<EnumValue, Object> {
    private String[] strValues;
    private int[] intValues;


    @Override
    public void initialize(EnumValue constraintAnnotation) {
        strValues = constraintAnnotation.strValues();
        intValues = constraintAnnotation.intValues();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o instanceof String) {
            for (String s : strValues) {
                if (s.equals(o)) {
                    return true;
                }
            }
        } else if (o instanceof Integer) {
            for (int s : intValues) {
                if (s == (Integer) o) {
                    return true;
                }
            }
        }
        return false;
    }
}
