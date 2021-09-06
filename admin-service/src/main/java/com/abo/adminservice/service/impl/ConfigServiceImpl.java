package com.abo.adminservice.service.impl;

import com.abo.adminservice.entity.Config;
import com.abo.adminservice.mapper.ConfigMapper;
import com.abo.adminservice.service.IConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置信息表 服务实现类
 * </p>
 *
 * @author abo
 * @since 2021-09-06
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

}
