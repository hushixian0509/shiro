package com.spring.shiro.demo.realm;

import com.spring.shiro.demo.entity.PermissionBean;
import com.spring.shiro.demo.entity.RoleBean;
import com.spring.shiro.demo.entity.UserBean;
import com.spring.shiro.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hushixian
 * @date 2019-04-29 19:37
 * 自定义Realm，实现授权与认证
 */
public class UserRealm  extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 用户授权
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("===执行授权===");
        Subject subject = SecurityUtils.getSubject();
        UserBean user = (UserBean) subject.getPrincipal();
        if(user != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 角色与权限字符串集合
            Collection<String> rolesCollection = new HashSet<>();
            Collection<String> premissionCollection  = new HashSet<>();
            // 读取并赋值用户角色与权限
            Set<RoleBean> roles = user.getRoles();
                    for (RoleBean role : roles){
                rolesCollection.add(role.getRoleName());
                List <PermissionBean> permissions = role.getPermissions();
                for (PermissionBean permission : permissions){
                    premissionCollection.add(permission.getmUrl());
                }
                info.addStringPermissions(premissionCollection);
            }
            info.addRoles(rolesCollection);
            return info;
        }
        return null;
    }

    /**
     * 用户认证
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        System.out.println("===执行认证===");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserBean bean = userService.findByName(token.getUsername());
        if(bean == null){
            throw  new UnknownAccountException();
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes("admin");
        return new SimpleAuthenticationInfo(bean,bean.getUserPassword(),credentialsSalt,getName());
    }

    // 模拟Shiro用户加密，假设用户密码为123456
    public static void main(String[] args) {
        // 用户名
        String username = "admin";
        // 用户密码
        String password = "123456";
        // 加密方式
        String hashAlgorithName = "MD5";
        // 加密次数
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        Object obj = new SimpleHash(hashAlgorithName, password,
                credentialsSalt, hashIterations);
        System.out.println(obj);
    }

}
