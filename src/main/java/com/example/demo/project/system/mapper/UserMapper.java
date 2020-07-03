package com.example.demo.project.system.mapper;

import com.example.demo.project.system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * user表 Mapper 接口
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询所有用户
     *
     * @param page
     * @return
     */
    List<User> findAll(Pagination page);

    /**
     * 根据角色id获取用户
     *
     * @param roleId
     * @param pagination 分页信息
     * @return
     */
    List<User> findByRoleId(@Param("roleId") Integer roleId, Pagination pagination);

    /**
     * 根据用户名获取用户
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 根据用户邮箱获得用户
     *
     * @param userEmail 邮箱
     * @return 用户
     */
    User findByUserEmail(String userEmail);
    /**
     * 根据用户Id获得用户
     * @param userId 用户Id
     * @return 用户
     */
    User findByUserId(Long userId);
}
