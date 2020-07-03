package com.example.demo.project.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.project.system.entity.User;
import com.example.demo.project.system.mapper.UserMapper;
import com.example.demo.project.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * user表 服务实现类
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final String USERS_CACHE_NAME = "users";

    @Autowired
    private UserMapper userMapper;
    
    /**
     * 新增/修改用户
     *
     * @param user
     * @return
     */
    @Override
    @CacheEvict(value = USERS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public User saveUpdateByUser(User user) {
        if (user != null && user.getUserId() != null) {
            userMapper.updateById(user);
        } else {
            userMapper.insert(user);
        }
        return user;
    }

    @Override
    @Cacheable(value = USERS_CACHE_NAME, key = "'users_name_'+#userName", unless = "#result==null")
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    @Cacheable(value = USERS_CACHE_NAME, key = "'users_email_'+#userEmail", unless = "#result == null")
    public User findByEmail(String userEmail) {
        return userMapper.findByUserEmail(userEmail);
    }

    @Override
    @Cacheable(value = USERS_CACHE_NAME, key = "'users_id_'+#userName", unless = "#result == null")
    public User findByUserId(Long userId) {
        return userMapper.findByUserId(userId);
    }

    /**
     * 修改禁用状态
     *
     * @param user
     * @param enable enable
     */
    @Override
    @CacheEvict(value = USERS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void updateUserLoginEnable(User user, String enable) {
        //如果是修改为正常, 重置错误次数
//        if (Objects.equals(TrueFalseEnum.TRUE.getDesc(), enable)) {
//            user.setLoginError(0);
//        }
        user.setLoginEnable(enable);
        this.updateUser(user);
    }

    /**
     * 修改最后登录时间
     *
     * @param user
     * @param lastDate 最后登录时间
     * @return
     */
    @Override
    @CacheEvict(value = USERS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public User updateUserLoginLast(User user, Date lastDate) {
        user.setLoginLast(lastDate);
        this.updateUser(user);
        return user;
    }

    /**
     * 增加登录错误次数
     *
     * @param user
     * @return
     */
    @Override
    @CacheEvict(value = USERS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public Integer updateUserLoginError(User user) {
        user.setLoginError((user.getLoginError() == null ? 0 : user.getLoginError()) + 1);
        this.updateUser(user);
        return user.getLoginError();
    }

    /**
     * 修改用户的状态为正常
     *
     * @return User
     */
    @Override
    @CacheEvict(value = USERS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public User updateUserLoginNormal(User user) {
//        user.setLoginEnable(TrueFalseEnum.TRUE.getDesc());
        user.setLoginError(0);
        user.setLoginLast(new Date());
        this.updateUser(user);
        return user;
    }

    /**
     * 修改用户
     *
     * @param user
     */
    @CacheEvict(value = USERS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

}
