package com.example.demo.project.system.mapper;

import com.example.demo.project.system.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * permission表 Mapper 接口
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据角色Id获得权限列表
     *
     * @param roleId 角色Id
     * @return 权限列表
     */
    List<Permission> findByRoleId(Long roleId);
    /**
     * 获得权限列表
     *
     * @return 权限列表
     */
    List<Permission> findAll();

}
