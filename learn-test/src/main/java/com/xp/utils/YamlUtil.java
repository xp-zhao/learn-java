package com.xp.utils;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;

/**
 * yml 资源文件读取工具
 * Created by xp-zhao on 2018/5/16.
 */
public class YamlUtil
{
	private static       HashMap<String, YamlUtil> configMap = new HashMap<>();
	// 打开文件时间，判断超时使用
	private              Date                      loadTime  = null;
	// 资源文件
	private              URL                       ymlUrl      = null;
	// 缓存时间
	private static final Integer                   TIME_OUT  = 60 * 1000;

	// 默认资源文件名称
	private static final String                    NAME      = "url";

 	// 单例
	private YamlUtil(String name)
	{
		this.loadTime = new Date();
		this.ymlUrl = YamlUtil.class.getClassLoader().getResource(name+".yml");
	}

	public static synchronized YamlUtil getInstance()
	{
		return getInstance(NAME);
	}

	public static synchronized YamlUtil getInstance(String name)
	{
		YamlUtil config = configMap.get(name);
		return config;
	}
}
