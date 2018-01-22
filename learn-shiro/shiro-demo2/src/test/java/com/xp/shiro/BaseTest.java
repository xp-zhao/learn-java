package com.xp.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;

/**
 * Created by xp-zhao on 2018/1/19.
 */
public abstract class BaseTest
{
	@After
	public void tearDown ()throws Exception
	{
		ThreadContext.unbindSubject();
	}

	protected void login(String configFile,String username,String password)
	{
		// 获取 SecurityManager 工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);

		// 得到 SecurityManager 实例，并绑定到 SecurityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		// 得到 Subject,并创建 UsernamePasswordToken
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);

		subject.login(token);
	}

	public Subject subject()
	{
		return SecurityUtils.getSubject();
	}

}
