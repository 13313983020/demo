package com.example.demo.project.system.service.impl;

import com.example.demo.project.system.entity.UserRole;
import com.example.demo.project.system.mapper.UserRoleMapper;
import com.example.demo.project.system.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * user_role表 服务实现类
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
