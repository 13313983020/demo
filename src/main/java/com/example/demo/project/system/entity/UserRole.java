package com.example.demo.project.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * user_role表
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 角色Id
     */
    private Integer roleId;


}
