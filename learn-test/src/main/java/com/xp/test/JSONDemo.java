package com.xp.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xp.model.ContentItem;
import com.xp.model.Model1;
import com.xp.model.Model2;

/**
 * Created by xp-zhao on 2018/5/25.
 */
public class JSONDemo
{
	public static void main(String[] args)
	{
		ContentItem item = new ContentItem();
		item.setContentId("123456");
		item.setContentName("测试");
		item.setContentType("2");
		item.setSingerId("345");
		item.setSingerName("xp");
		item.setSongId("234");
		Model2 model2 = new Model2();
		model2.setId("222222222222");
		Model1 model1 = new Model1();
		model1.setName("model1");
		item.setModel1(model1);
		item.setModel2(model2);
		System.out.println(tsgRequestParam(item));
	}
	public static String tsgRequestParam(Object object)
	{
		JSONObject param = new JSONObject();
		JSONArray array = new JSONArray();
		array.add(object);
		param.put("data" , array);
//		return param.toJSONString();
		return param.toJSONString();
	}
}
