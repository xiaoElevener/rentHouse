package com.xiao.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import com.xiao.entity.Users;
import com.xiao.service.UserService;

@Component
public class MyRealm extends AuthorizingRealm {
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 为当前登陆成功的用户授予权限和角色，已经登陆成功了
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("为当前登陆成功的用户授予权限和角色，已经登陆成功了");
		String username = (String) principals.getPrimaryPrincipal(); // 获取用户名
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.findRolesByUsername(username));
		return authorizationInfo;
	}

	// 验证当前登录的用户，获取认证信息
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("验证当前登录的用户，获取认证信息");
		String username = (String) token.getPrincipal(); // 获取用户名
		Users u = new Users();
		u.setUsername(username);
		Users user = userService.login(u);
		
		if (user != null) {
			ByteSource salt = ByteSource.Util.bytes(user.getUserId().toString());//这里的参数要给个唯一的;
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
					user.getUsername(), user.getPassword(),salt,"myRealm");
			System.out.println("--------------authcInfo----------------");
			return authcInfo;
		} else {
			return null;
		}
	}
}
