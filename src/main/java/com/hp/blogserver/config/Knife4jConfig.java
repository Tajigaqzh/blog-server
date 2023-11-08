package com.hp.blogserver.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;


/**
 * @Author 20126
 * @Description
 * @Date 2023/11/7 7:19
 * @Version 1.0
 */
@Slf4j
@EnableKnife4j
@SpringBootConfiguration
public class Knife4jConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("spring boot接口")
                                .contact(
                                        new Contact()
                                                .name("祁自豪")
                                                .email("201267151@qq.com")
                                                .url("XXXXX"))
                                .version("1.0")
                                .description("后台管理接口")
                                .license(new License().name("Apache 2.0"))
                );

    }


}
