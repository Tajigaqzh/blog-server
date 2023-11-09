package com.hp.blogserver.common.vo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/10 6:24
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPageVo {
    @NotNull
    private Integer currentPage;

    @NotNull
    @Max(value = 50, message = "pageSize最大不超过50")
    private Integer pageSize;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private String username;

    private String mobile;

    private Boolean enabled;

    private Long deptId;
}
