package com.xp.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xp-zhao on 2018/5/14.
 */
public class ListUtil
{
	public static void main(String[] args)
	{
		List<String> list1 = null;
		List<String> list2 = new ArrayList<>();
		System.out.println(isNull(list1));
		System.out.println(isNull(list2));
	}

	public static boolean isNull(List<String> list)
	{
		if(null != list && list.size() > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
