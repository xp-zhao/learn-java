package com.xp.TSG;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xp-zhao on 2018/5/25.
 */
public class ParamDemo
{
	public static void main(String[] args)
	{
		TSGPlayList playList = new TSGPlayList();
		playList.setPlay_list_id("2013");
		playList.setPlay_list_name("测试歌单");
		playList.setPlay_list_type("2");
		playList.setIdentity_id("2013051233");
		List<TSGTag> tsgs = new ArrayList<>();
		tsgs.add(new TSGTag("tag1","tagtest1",1));
		tsgs.add(new TSGTag("tag2","tagtest2",1));
		tsgs.add(new TSGTag("tag3","tagtest3",1));
		playList.setTags(tsgs);
		List<TSGContent> contents = new ArrayList<>();
		contents.add(new TSGContent("content1"));
		contents.add(new TSGContent("content2"));
		contents.add(new TSGContent("content3"));
		contents.add(new TSGContent("content4"));
		playList.setContents(contents);
		System.out.println(tsgRequestParam(playList));
	}

	public static String tsgRequestParam(Object object)
	{
		JSONObject param = new JSONObject();
		JSONArray array = new JSONArray();
		array.add(object);
		param.put("data" , array);
		return param.toJSONString();
	}
}
