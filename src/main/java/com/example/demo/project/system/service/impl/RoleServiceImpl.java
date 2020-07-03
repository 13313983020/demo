package com.example.demo.project.system.service.impl;

import com.example.demo.project.system.entity.Role;
import com.example.demo.project.system.mapper.RoleMapper;
import com.example.demo.project.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * role表 服务实现类
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    private static final String ROLES_CACHE_NAME = "roles";

    @Autowired
    private RoleMapper roleMapper;


    @Override
    @CacheEvict(value = ROLES_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public Role saveByRole(Role role) {
        if (role != null && role.getId() != null) {
            roleMapper.updateById(role);
        } else {
            roleMapper.insert(role);
        }
        return role;
    }

    @Override
    @CacheEvict(value = ROLES_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void removeByRoleId(Long roleId) {
        roleMapper.deleteById(roleId);
    }

    @Override
    @CacheEvict(value = ROLES_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void removeByUserId(Long userId) {
        roleMapper.deleteByUserId(userId);
    }

    @Override
    @Cacheable(value = ROLES_CACHE_NAME, key = "'roles_id_'+#roleId", unless = "#result == null")
    public Role findByRoleId(Long roleId) {
        return roleMapper.selectById(roleId);
    }

    @Override
    @Cacheable(value = ROLES_CACHE_NAME, key = "'roles_name_'+#roleName", unless = "#result == null")
    public Role findByRoleName(String roleName) {
        return roleMapper.findByRoleName(roleName);
    }

    @Override
    @Cacheable(value = ROLES_CACHE_NAME, key = "'roles_uid_'+#userId", unless = "#result == null")
    public List<Role> listRolesByUserId(Long userId) {
        return roleMapper.findByUserId(userId);
    }

    @Override
    @Cacheable(value = ROLES_CACHE_NAME, key = "'roles_all'")
    public List<Role> findAll() {
        //获得角色
        List<Role> roles = roleMapper.findAll();
        //封装count
        roles.forEach(role -> role.setCount(roleMapper.countUserByRoleId(role.getId())));
        return roles;
    }
}
