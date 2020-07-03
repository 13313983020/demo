package com.example.demo.project.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.project.system.entity.User;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * user表 服务类
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
public interface IUserService extends IService<User> {
    
    /**
     * 新增/修改用户
     *
     * @param user
     * @return
     */
    User saveUpdateByUser(User user);

    /**
     * 根据用户名查找用户
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 根据邮箱查找用户
     *
     * @param userEmail 邮箱
     * @return User
     */
    User findByEmail(String userEmail);

    /**
     * 根据用户Id获得用户
     *
     * @param userId 用户名
     * @return 用户
     */
    User findByUserId(Long userId);

    /**
     * 修改禁用状态
     *
     * @param enable enable
     */
    void updateUserLoginEnable(User user, String enable);

    /**
     * 修改最后登录时间
     *
     * @param lastDate 最后登录时间
     * @return User
     */
    User updateUserLoginLast(User user, Date lastDate);

    /**
     * 增加登录错误次数
     *
     * @return 登录错误次数
     */
    Integer updateUserLoginError(User user);

    /**
     * 修改用户的登录状态为正常
     *
     * @return User
     */
    User updateUserLoginNormal(User user);

}
