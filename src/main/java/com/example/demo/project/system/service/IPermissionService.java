package com.example.demo.project.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.project.system.entity.Permission;

import java.util.List;

/**
 * <p>
 * permission表 服务类
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
public interface IPermissionService extends IService<Permission> {
    /**
     * 新增/修改权限
     *
     * @param permission permission
     * @return Permission
     */
    Permission saveByPermission(Permission permission);

    /**
     * 根据编号删除
     *
     * @param permissionId permissionId
     * @return Permission
     */
    void removeByPermissionId(Integer permissionId);

    /**
     * 根据编号查询单个权限
     *
     * @param permissionId permissionId
     * @return Permission
     */
    Permission findByPermissionId(Long permissionId);

    /**
     * 根据角色Id获得权限列表
     *
     * @param roleId 角色Id
     * @return 权限列表
     */
    List<Permission> listPermissionsByRoleId(Long roleId);
}
