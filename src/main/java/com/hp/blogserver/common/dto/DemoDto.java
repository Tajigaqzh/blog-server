package com.hp.blogserver.common.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 11:50
 * @Version 1.0
 */

@Data
public class DemoDto {
    @Length(max = 5,message = "参数错误")
    String username;
}
