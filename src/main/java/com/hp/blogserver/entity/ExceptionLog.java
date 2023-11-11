package com.hp.blogserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 15:42
 * @Version 1.0
 */
@Data
@TableName(value = "exception_log")
@Schema(description = "日志异常记录")
public class ExceptionLog {

}
