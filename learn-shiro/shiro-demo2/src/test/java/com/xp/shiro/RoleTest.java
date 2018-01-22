package com.xp.shiro;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by xp-zhao on 2018/1/19.
 */
public class RoleTest extends BaseTest
{
	@Test
	public void hasRoleTest()
	{
		login("classpath:shiro-role.ini","zhao","123");
		System.out.println(subject().hasRole("role1"));
		System.out.println(subject().hasAllRoles(Arrays.asList("role1","role2")));
		boolean[] result = subject().hasRoles(Arrays.asList("role1","role2","role3"));
		System.out.println(result.length);
	}

	@Test
	public void checkRoleTest()
	{
		login("classpath:shiro-role.ini","zhao","123");
		subject().checkRole("role111");
	}
}
