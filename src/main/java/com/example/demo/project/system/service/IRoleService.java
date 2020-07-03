package com.example.demo.project.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.project.system.entity.Role;

import java.util.List;

/**
 * <p>
 * role表 服务类
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
public interface IRoleService extends IService<Role> {
    /**
     * 新增/修改角色
     *
     * @param role role
     * @return Role
     */
    Role saveByRole(Role role);

    /**
     * 根据编号删除
     *
     * @param roleId roleId
     * @return Role
     */
    void removeByRoleId(Long roleId);

    /**
     * 删除某个用户的所有关联
     *
     * @param userId 用户Id
     */
    void removeByUserId(Long userId);

    /**
     * 根据编号查询单个权限
     *
     * @param roleId roleId
     * @return Role
     */
    Role findByRoleId(Long roleId);

    /**
     * 根据编号查询单个权限
     *
     * @param roleName roleName
     * @return Role
     */
    Role findByRoleName(String roleName);

    /**
     * 根据用户Id获得角色列表
     *
     * @param userId 用户Id
     * @return 角色列表
     */
    List<Role> listRolesByUserId(Long userId);

    /**
     * 获得所有的角色
     *
     * @return 角色列表
     */
    List<Role> findAll();
}
