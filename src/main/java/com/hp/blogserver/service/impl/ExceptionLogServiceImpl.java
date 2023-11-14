package com.hp.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.blogserver.entity.ExceptionLog;
import com.hp.blogserver.mapper.ExceptionLogMapper;
import com.hp.blogserver.service.IExceptionLogService;
import org.springframework.stereotype.Service;

/**
 * 日志异常记录 实现类
 *
 * @author zqd
 * @Date 2023-11-15 06:19:40
 */
@Service
public class ExceptionLogServiceImpl extends ServiceImpl<ExceptionLogMapper, ExceptionLog> implements IExceptionLogService {

}
