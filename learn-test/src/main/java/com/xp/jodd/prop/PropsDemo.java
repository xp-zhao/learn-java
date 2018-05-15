package com.xp.jodd.prop;

import jodd.props.Props;

import java.io.File;
import java.io.IOException;

/**
 * Created by xp-zhao on 2018/5/15.
 */
public class PropsDemo
{
	public static void main(String[] args) throws IOException
	{
		Props p = new Props();
		System.out.println(PropsDemo.class.getResource("url.props"));
//		p.load(new File(URLUtil.getClassPath(PropsDemo.class.getClass())+"url.props"));
		p.loadEnvironment("url.props");
		String story = p.getValue("key1");
		System.out.println(story);
	}
}
