package com.example.demo.project.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * user表
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 是否禁用登录
     */
    private String loginEnable;

    /**
     * 登录错误次数记录
     */
    private Integer loginError;

    /**
     * 最后一次登录时间
     */
    private Date loginLast;

    /**
     * 头像
     */
    private String userAvatar;

    /**
     * 说明
     */
    private String userDesc;

    /**
     * 显示名称
     */
    private String userDisplayName;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPass;

    /**
     * 个人主页
     */
    private String userSite;

    /**
     * 0 正常 1 禁用 2 已删除
     */
    private Integer status;

    /**
     * 注册时间
     */
    private LocalDateTime reateTime;

}
