package com.example.demo.project.system.controller;


import com.example.demo.project.system.entity.User;
import com.example.demo.project.system.service.IPermissionService;
import com.example.demo.project.system.service.IRoleService;
import com.example.demo.project.system.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * user表 前端控制器
 * </p>
 *
 * @author 小雨淅淅
 * @since 2020-06-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final String prefix = "system/user";

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    @RequiresPermissions("system:user:queryAll")
    @GetMapping("/queryAll")
    public String queryAll(){
        return "查询列表";
    }

    @GetMapping("/add")
    public String userAdd(){
        return "添加用户";
    }

    @RequiresPermissions("system:user:add")
    @PostMapping("/add")
    @ResponseBody
    public void addSave(@Validated User user){
        userService.saveUpdateByUser(user);
    }

    @RequiresPermissions("system:user:delete")
    @GetMapping("/delete")
    public String userDelete(){
        return "删除用户";
    }

}
