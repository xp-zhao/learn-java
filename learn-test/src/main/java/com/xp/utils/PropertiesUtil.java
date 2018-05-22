package com.xp.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * properties 资源文件读取工具
 * Created by xp-zhao on 2018/5/4.
 */
public class PropertiesUtil
{
	private static       HashMap<String,PropertiesUtil> configMap      = new HashMap<>();
	// 打开文件时间，判断超时使用
	private              Date                           loadTime       = null;
	// 资源文件
	private              ResourceBundle                 resourceBundle = null;
	// 缓存时间
	private static final Integer                        TIME_OUT       = 60 * 1000;

	// 默认资源文件名称
	private static final String NAME = "sso-config";

	// 私有构造方法，创建单例
	private PropertiesUtil(String name) {
		this.loadTime = new Date();
		this.resourceBundle = ResourceBundle.getBundle(name);
	}

	public static synchronized PropertiesUtil getInstance() {
		return getInstance(NAME);
	}

	public static synchronized PropertiesUtil getInstance(String name) {
		PropertiesUtil conf = configMap.get(name);
		if (null == conf) {
			conf = new PropertiesUtil(name);
			configMap.put(name, conf);
		}
		// 判断是否打开的资源文件是否超时1分钟
		if ((System.currentTimeMillis() - conf.getLoadTime().getTime()) > TIME_OUT) {
			conf = new PropertiesUtil(name);
			configMap.put(name, conf);
		}
		return conf;
	}

	// 根据key读取value
	public String get(String key) {
		try {
			String value = resourceBundle.getString(key);
			return value;
		} catch (MissingResourceException e) {
			return "";
		}
	}

	// 根据key读取value(整形)
	public Integer getInt(String key) {
		try {
			String value = resourceBundle.getString(key);
			return Integer.parseInt(value);
		} catch (MissingResourceException e) {
			return null;
		}
	}

	// 根据key读取value(布尔)
	public boolean getBool(String key) {
		try {
			String value = resourceBundle.getString(key);
			if ("true".equals(value)) {
				return true;
			}
			return false;
		} catch (MissingResourceException e) {
			return false;
		}
	}

	public Date getLoadTime() {
		return loadTime;
	}

}
