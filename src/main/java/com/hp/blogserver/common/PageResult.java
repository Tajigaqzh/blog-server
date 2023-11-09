package com.hp.blogserver.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
public class PageResult implements Serializable {
    private Object records;
    private Long pageSize;
    private Long total;
    private Long currentPage;

    public static <T> PageResult getInstance(IPage<T> page) {
        return PageResult.builder()
                .pageSize(page.getSize())
                .records(page.getRecords())
                .total(page.getTotal())
                .currentPage(page.getCurrent()).build();
    }
}
