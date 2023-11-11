package com.hp.blogserver.validate;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;


/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 13:57
 * @Version 1.0
 */
@SpringBootConfiguration
public class ValidateConfig {
    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure().failFast(true).buildValidatorFactory();

        return validatorFactory.getValidator();
    }
}
