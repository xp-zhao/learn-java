package com.xp.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *  反射操作的封装
 * Created by xp-zhao on 2018/4/12.
 */
public class BeanUtils
{
	/**
	 * 实例化  class
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T instanceClass(Class<T> clazz)
	{
		if(!clazz.isInterface())
		{
			try
			{
				return clazz.newInstance();
			}
			catch (InstantiationException e)
			{
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 通过构造函数实例化
	 * @param ctor
	 * @param args
	 * @param <T>
	 * @return
	 */
	public static <T> T instanceClass(Constructor<T> ctor, Object... args)
		throws IllegalAccessException, InvocationTargetException, InstantiationException
	{
		makeAccessible(ctor);
		return ctor.newInstance(args);
	}

	public static void makeAccessible(Constructor<?> ctor)
	{
		if((!Modifier.isPublic(ctor.getModifiers()) ||
			Modifier.isPublic(ctor.getDeclaringClass().getModifiers())) && !ctor.isAccessible())
		{
			ctor.setAccessible(true);
		}
	}

	/**
	 * 查找某个 class 的方法
	 * @param clazz
	 * @param methodName
	 * @param paramType
	 * @return
	 */
	public static Method findMethod(Class<?> clazz,String methodName,Class<?>... paramType)
	{
		try
		{
			return clazz.getMethod(methodName,paramType);
		}
		catch (NoSuchMethodException e)
		{
			return findDeclareMethod(clazz,methodName,paramType);
		}
	}

	public static Method findDeclareMethod(Class<?> clazz,String methodName,Class<?>[] paramTypes)
	{
		try
		{
			return clazz.getDeclaredMethod(methodName,paramTypes);
		}
		catch (NoSuchMethodException e)
		{
			if(clazz.getSuperclass() != null)
			{
				return findDeclareMethod(clazz.getSuperclass(),methodName,paramTypes);
			}
			return null;
		}
	}

	public static Method[] findDeclareMethods(Class<?> clazz)
	{
		return clazz.getDeclaredMethods();
	}
}
