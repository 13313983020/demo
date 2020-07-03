package com.example.demo.project.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * role表
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private Long id;

    /**
     * 角色名称：admin，author，subscriber
     */
    private String role;

    /**
     * 角色名称：admin，author，subscriber
     */
    private String description;

    /**
     * 该角色对应的用户数量
     */
    @TableField(exist = false)
    private Integer count;


}
