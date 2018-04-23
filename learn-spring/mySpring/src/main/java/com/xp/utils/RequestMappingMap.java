package com.xp.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储方法的访问路径
 * Created by xp-zhao on 2018/4/12.
 */
public class RequestMappingMap
{
	private static Map<String,Class<?>> requestMap = new HashMap<String,Class<?>>();

	public static Class<?> getClassName(String path)
	{
		return requestMap.get(path);
	}

	public static void put(String path,Class<?> className)
	{
		requestMap.put(path,className);
	}

	public static Map<String,Class<?>> getRequestMap()
	{
		return requestMap;
	}
}
