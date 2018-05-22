package com.xp.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xp-zhao on 2018/5/16.
 */
public class ListDemo
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList();
		list.add("test1");
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");
		System.out.println(list.toString());
		String listStr = list.toString();
		String regex;
		Pattern pattern;
		Matcher matcher;
		int maxNum = 0;
		String maxStr = "";
		String tempStr = "";
		for(String str : list)
		{
			if(tempStr.equals(str))
			{
				continue;
			}
			tempStr = str;
			regex = tempStr;
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(listStr);
			int num = 0;
			while(matcher.find())
			{
				num++;
			}
			if(num > maxNum)
			{
				maxNum = num;
				maxStr = str;
			}
		}
		System.out.println("maxStr: "+maxStr+" ; maxNum: "+maxNum);
	}
}
