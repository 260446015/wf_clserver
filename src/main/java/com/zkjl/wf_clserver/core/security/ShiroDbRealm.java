package com.zkjl.wf_clserver.core.security;

import com.zkjl.wf_clserver.core.entity.SysUser;
import com.zkjl.wf_clserver.core.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;


public class ShiroDbRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Resource
	private EhCacheManager ehCacheManager;

	
	
	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		
		char[] str = upToken.getPassword();
		String password = String.valueOf(str);
		SysUser login = userService.login(username, password);
//		String userBate = userDocment.getString("userBate");
		
		SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		if(null != sysUser){
			throw new AuthenticationException("用户已经登录!");
		}
//	    session.setAttribute("CURRENT_USERBATE", userBate);
		Object principal = null;
		Object credentials = null;
		if (login != null) {
			//以下信息是从数据库中获取的.
			//1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象. 
			principal = login;
			//2). credentials: 密码. 
			credentials = login.getPassword();
		}
		
		//3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
		String realmName = getName();
		//4). 盐值. 
		//ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		
		AuthenticationInfo info = null; 
		info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		return  info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pricinal) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		SysUser sysUser = (SysUser) pricinal.getPrimaryPrincipal();
		if(true == sysUser.getIfAdmin()){
			Set<String> permissions = new HashSet<>();
			permissions.add("admin");
			authorizationInfo.setStringPermissions(permissions);
		}
		return authorizationInfo;
	}

	@Override
	public void onLogout(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
		SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
		removeUserCache(sysUser.getUsername());
	}

	/**
	 * 清楚用户缓存
	 */
	private void removeUserCache(String username) {
		System.out.println("清楚缓存用户"+username);

		ehCacheManager.getCache("shiroCache").remove(username);
		System.out.println("缓存大小"+ehCacheManager.getCache("shiroCache").size());
	}
}



