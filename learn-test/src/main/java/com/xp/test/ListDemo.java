package com.xp.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xp-zhao on 2018/5/24.
 */
public class ListDemo
{
	public static void main(String[] args)
	{
		List<String> all = new ArrayList<>();
		all.add("1");
		all.add("2");
		all.add("3");
		all.add("4");
		List<String> test = new ArrayList<>();
		test.add("1");
		test.add("2");
		test.add("3");
		System.out.println(all.removeAll(test));
		System.out.println(all);
	}
}
