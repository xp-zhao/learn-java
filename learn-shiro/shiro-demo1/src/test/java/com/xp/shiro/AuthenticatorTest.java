package com.xp.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Created by xp-zhao on 2018/1/19.
 */
public class AuthenticatorTest
{
	@Test
	public void allSuccessTest()
	{
		login("classpath:shiro-authenticator-all-success.ini");
		Subject subject = SecurityUtils.getSubject();
		PrincipalCollection collection = subject.getPrincipals();
		System.out.println(collection.asList().size());
	}

	private void login(String configFile)
	{
		// 获取 SecurityManager 工厂(使用 ini 配置文件初始化 SecurityManager)
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);

		// 得到 SecurityManager 实例，并绑定到 SecurityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		// 得到 Subject ,并创建 UsernamePasswordToken
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhao","123");
		subject.login(token);
	}
}
