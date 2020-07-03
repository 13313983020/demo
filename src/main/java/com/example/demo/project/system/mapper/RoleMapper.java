package com.example.demo.project.system.mapper;

import com.example.demo.project.system.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * role表 Mapper 接口
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户Id获得角色列表
     *
     * @param userId 用户Id
     * @return 角色列表
     */
    List<Role> findByUserId(Long userId);
    /**
     * 根据名称获得角色
     *
     * @param roleName 角色名
     * @return 角色
     */
    Role findByRoleName(String roleName);
    /**
     * 获得角色列表
     *
     * @return 角色列表
     */
    List<Role> findAll();
    /**
     * 删除用户和角色管理
     *
     * @param userId 用户ID
     * @return 影响行数
     */
    Integer deleteByUserId(Long userId);
    /**
     * 统计某个角色的用户数
     *
     * @param roleId 角色Id
     * @return 用户数
     */
    Integer countUserByRoleId(Long roleId);

}
