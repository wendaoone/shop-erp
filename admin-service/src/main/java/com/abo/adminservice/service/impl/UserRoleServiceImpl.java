package com.abo.adminservice.service.impl;

import com.abo.adminservice.entity.UserRole;
import com.abo.adminservice.mapper.UserRoleMapper;
import com.abo.adminservice.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author abo
 * @since 2021-09-06
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
