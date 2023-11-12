package com.hp.blogserver.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author 20126
 * @Description 权限-菜单树形结构
 * @Date 2023/11/11 20:11
 * @Version 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuPermTreeVO {
    /**
     * 菜单权限id
     */
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单id
     */
    private Long parentId;

    /**
     * 是否启用
     */
    private Boolean disabled;
}
