package com.abo.adminservice.service.impl;

import com.abo.adminservice.entity.Log;
import com.abo.adminservice.mapper.LogMapper;
import com.abo.adminservice.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author abo
 * @since 2021-09-06
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
