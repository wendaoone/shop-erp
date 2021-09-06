package com.abo.adminservice.service.impl;

import com.abo.adminservice.entity.Role;
import com.abo.adminservice.mapper.RoleMapper;
import com.abo.adminservice.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author abo
 * @since 2021-09-06
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
