package com.hgz.shiroconfig;

import com.hgz.dao.UserDao;
import com.hgz.pojo.TbUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;

    /**
     * 权限相关
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //数据库获取账户权限信息
        Set<String> stringSet = new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);
        return info;
    }

    /**
     * 身份认证
     * 这里可以注入userService,为了方便演示直接写死账户和密码
     * 获取即将需要认证的信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String userpwd = new String((char[]) authenticationToken.getCredentials());
        //数据库获取用户名
        List<TbUser> byUsername = userDao.findByUsername(userName);
        if (byUsername == null) {
            //throw new AccountException("用户名不正确");
        } else if (!userpwd.equals(byUsername.get(0).getPassword())) {
            //throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(userName, byUsername.get(0).getPassword(), getName());
    }
}
