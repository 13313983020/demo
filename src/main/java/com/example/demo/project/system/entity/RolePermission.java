package com.example.demo.project.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * role_permission表
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_permission")
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色Id
     */
    private Integer roleId;

    /**
     * 权限Id
     */
    private Integer permissionId;


}
