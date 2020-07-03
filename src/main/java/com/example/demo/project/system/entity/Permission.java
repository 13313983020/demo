package com.example.demo.project.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * permission表
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限：user:list，user:add等
     */
    private String permission;


}
