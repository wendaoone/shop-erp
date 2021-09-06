package com.abo.adminservice.service.impl;

import com.abo.adminservice.entity.User;
import com.abo.adminservice.mapper.UserMapper;
import com.abo.adminservice.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author abo
 * @since 2021-09-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
