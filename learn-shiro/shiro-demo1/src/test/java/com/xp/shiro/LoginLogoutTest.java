package com.xp.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Created by xp-zhao on 2018/1/19.
 */
public class LoginLogoutTest
{
	@Test
	public void  CustomRealmTest()
	{
		// 1.获取 SecurityManager 工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

		// 得到 SecurityManager 实例，并绑定给 SecurityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		// 得到 Subject 并创建 UsernamePasswordToken
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhao","124");
		try
		{
			// 登录，即身份验证
			subject.login(token);
		}
		catch (AuthenticationException e)
		{
			System.out.println("身份验证失败");
		}
		// 退出
		subject.logout();
	}

	@Test
	public void JDBCRealmTest()
	{
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhao","123456");
		try
		{
			subject.login(token);
		}
		catch (AuthenticationException e)
		{
			System.out.println("身份验证失败！");
		}
		subject.logout();
	}
}
