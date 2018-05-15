package com.xp.yaml;

import org.ho.yaml.Yaml;

import java.io.FileInputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by xp-zhao on 2018/5/15.
 */
public class yamlDemo
{
	public static void main(String[] args)
	{
		try {
			Yaml yaml = new Yaml();
			URL url = yamlDemo.class.getClassLoader().getResource("url.yml");
			if (url != null) {
				//url.yaml文件中的配置数据，然后转换为obj，
				Object obj =yaml.load(new FileInputStream(url.getFile()));
//				System.out.println(obj);
				//也可以将值转换为Map
				Map map =(Map)yaml.load(new FileInputStream(url.getFile()));
				System.out.println(map.get("authorization_urls"));
				List<String> urls = (List<String>) map.get("authorization_urls");
				System.out.println(urls.get(2));
				//通过map我们取值就可以了.

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
