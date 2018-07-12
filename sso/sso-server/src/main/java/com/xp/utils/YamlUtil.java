package com.xp.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

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
	private              URL                       ymlUrl    = null;
	private              Yaml                      yaml      = new Yaml();
	// 缓存时间
	private static final Integer                   TIME_OUT  = 60 * 1000;
	// 默认资源文件名称
	private static final String                    NAME      = "filter-url";

	// 单例
	private YamlUtil(String name)
	{
		this.loadTime = new Date();
		this.ymlUrl = YamlUtil.class.getClassLoader().getResource(name + ".yml");
	}

	public static synchronized YamlUtil getInstance()
	{
		return getInstance(NAME);
	}

	public static synchronized YamlUtil getInstance(String name)
	{
		YamlUtil config = configMap.get(name);
		if(null == config)
		{
			config = new YamlUtil(name);
			configMap.put(name , config);
		}
		// 判断是否打开的资源文件是否超时1分钟
		if((System.currentTimeMillis() - config.getLoadTime().getTime()) > TIME_OUT)
		{
			config = new YamlUtil(name);
			configMap.put(name , config);
		}
		return config;
	}

	public List<String> getList(String key)
	{
		List<String> filter = new ArrayList<>();
		//将值转换为Map
		try
		{
			Map map = yaml.load(new FileInputStream(ymlUrl.getFile()));
			filter = (List<String>) map.get(key);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return filter;
	}

	public Date getLoadTime()
	{
		return loadTime;
	}
}
