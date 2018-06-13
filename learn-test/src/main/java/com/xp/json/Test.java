package com.xp.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xp-zhao on 2018/6/5.
 */
public class Test
{
	public static void main(String[] args)
	{
		Map<String, String> map = new HashMap<>();
		map.put("count1" , "1");
		TestModel testModel = new TestModel();
		testModel.setCount1(Integer.valueOf(map.get("count1")));
		testModel.setCount2(Integer.valueOf(map.get("count2")));
		System.out.println(testModel.toString());
	}
}
