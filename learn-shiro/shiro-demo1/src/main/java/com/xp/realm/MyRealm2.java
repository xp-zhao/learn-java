package com.xp.realm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by xp-zhao on 2018/1/19.
 */
public class MyRealm2 implements Realm
{
	@Override
	public String getName()
	{
		return "myrealm2";
	}

	@Override
	public boolean supports(AuthenticationToken authenticationToken)
	{
		// 仅支持 UsernamePasswordToken 类型的 Token
		return authenticationToken instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
		throws AuthenticationException
	{
		// 获取用户名
		String username = (String) token.getPrincipal();
		// 获取密码
		String password = new String((char[])token.getCredentials());

		if(!"zhao2".equals(username))
		{
			// 用户名错误
			throw new UnknownAccountException();
		}
		if(StringUtils.isBlank(password))
		{
			// 密码错误
			throw new IncorrectCredentialsException();
		}
		// 身份验证成功，返回一个  AuthenticationInfo 实现
		return new SimpleAuthenticationInfo(username,password,getName());
	}
}
