package com.abo.adminservice.service.impl;

import com.abo.adminservice.entity.Dept;
import com.abo.adminservice.mapper.DeptMapper;
import com.abo.adminservice.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门管理 服务实现类
 * </p>
 *
 * @author abo
 * @since 2021-09-06
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
