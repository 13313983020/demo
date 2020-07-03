package com.example.demo.project.system.service.impl;

import com.example.demo.project.system.entity.Permission;
import com.example.demo.project.system.mapper.PermissionMapper;
import com.example.demo.project.system.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * permission表 服务实现类
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    private static final String PERMISSION_CACHE_NAME = "permissions";

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    @CacheEvict(value = PERMISSION_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public Permission saveByPermission(Permission permission) {
        if (permission != null && permission.getId() != null) {
            permissionMapper.updateById(permission);
        } else {
            permissionMapper.insert(permission);
        }
        return permission;
    }

    @Override
    @CacheEvict(value = PERMISSION_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void removeByPermissionId(Integer permissionId) {
        permissionMapper.deleteById(permissionId);
    }

    @Override
    @Cacheable(value = PERMISSION_CACHE_NAME, key = "'permission_id_'+#permissionId", unless = "#result == null")
    public Permission findByPermissionId(Long permissionId) {
        return permissionMapper.selectById(permissionId);
    }

    @Override
    @Cacheable(value = PERMISSION_CACHE_NAME, key = "'roles_id_'+#roleId", unless = "#result == null")
    public List<Permission> listPermissionsByRoleId(Long roleId) {
        return permissionMapper.findByRoleId(roleId);
    }
}
