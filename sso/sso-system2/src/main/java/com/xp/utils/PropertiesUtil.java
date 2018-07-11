package com.xp.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by xp-zhao on 2018/7/9.
 */
public class PropertiesUtil
{
	private static Properties props;

	static {
		String fileName = "config.properties";
		props = new Properties();
		try {
			props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
		} catch (IOException e) {
			System.out.println("配置文件读取异常");
		}
	}

	public static String getProperty(String key){
		String value = props.getProperty(key.trim());
		if(StringUtils.isBlank(value)){
			return null;
		}
		return value.trim();
	}

	public static String getProperty(String key,String defaultValue){

		String value = props.getProperty(key.trim());
		if(StringUtils.isBlank(value)){
			value = defaultValue;
		}
		return value.trim();
	}
}
