package com.xp.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by xp-zhao on 2018/5/3.
 */
public class SprintUtil implements ApplicationContextAware
{
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		SprintUtil.applicationContext = applicationContext;
	}

	public static <T> T getBean(String name)
	{
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz)
	{
		checkApplicationContext();
		return (T) applicationContext.getBeansOfType(clazz);
	}

	public static void cleanApplicationContext()
	{
		applicationContext = null;
	}

	private static void checkApplicationContext()
	{
		if (applicationContext == null)
		{
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}
}
