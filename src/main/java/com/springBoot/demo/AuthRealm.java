package com.springBoot.demo;

import com.springBoot.demo.entity.Permission;
import com.springBoot.demo.entity.Role;
import com.springBoot.demo.entity.User;
import com.springBoot.demo.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;
    //授权使用
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user=(User)principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList=new ArrayList<>();
        Set<Role> roleSet=user.getRoles();
        if (CollectionUtils.isNotEmpty(roleSet)){
            for(Role role:roleSet){
                Set<Permission> permissionSet=role.getPermissions();
                if(CollectionUtils.isNotEmpty(permissionSet)){
                    for(Permission permission:permissionSet){
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        return info;
    }


    //认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) authenticationToken;
        String username=usernamePasswordToken.getUsername();
        User user=userService.findUserByUsername(username);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
