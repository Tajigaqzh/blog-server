package com.hp.blogserver.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/14 22:36
 * @Version 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouteVO {
    private String path;
    private String name;
    private String component;
    private Meta meta;

    private String redirect;

    private List<RouteVO> children;

    @Data
    public static class Meta{
        private String title;
        private String icon;
        private boolean showLink;
        private int rank;
        private List<String> roles;
        private List<String> auths;
    }

}
