package com.example.demo.framework.shiro;

import com.example.demo.project.system.entity.Permission;
import com.example.demo.project.system.entity.Role;
import com.example.demo.project.system.entity.User;
import com.example.demo.project.system.service.IPermissionService;
import com.example.demo.project.system.service.IRoleService;
import com.example.demo.project.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * shiro realm
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    /**
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("授权-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        List<Role> roles = roleService.listRolesByUserId(user.getUserId());
        for (Role role : roles) {
            authorizationInfo.addRole(role.getRole());
            List<Permission> permissions = permissionService.listPermissionsByRoleId(role.getId());
            for (Permission p : permissions) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 认证信息(身份验证) Authentication 是用来验证用户身份
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        log.info("认证-->MyShiroRealm.doGetAuthenticationInfo()");

        User user = null;

        String loginName = (String) authenticationToken.getPrincipal();

        user = userService.findByUserName(loginName);

        if (user == null) {
            //用户不存在
            log.info("用户不存在! 登录名:{}, 密码:{}", loginName, authenticationToken.getCredentials());
            return null;
        }

        //3.封装authenticationInfo，准备验证密码
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, // 用户名
                user.getUserPass(), // 密码
                ByteSource.Util.bytes("sens"), // 盐
                getName() // realm name
        );
        System.out.println("realName:" + getName());
        return authenticationInfo;
    }
}
