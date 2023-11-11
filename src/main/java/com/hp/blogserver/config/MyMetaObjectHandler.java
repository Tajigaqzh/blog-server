package com.hp.blogserver.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.hp.blogserver.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/11 15:50
 * @Version 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入的时候填充日期
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createBy", SecurityUtils.getCurrentUserName(), metaObject);

    }

    /**
     * 更新的时候填充日期
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", SecurityUtils.getCurrentUserName(), metaObject);
    }
}
