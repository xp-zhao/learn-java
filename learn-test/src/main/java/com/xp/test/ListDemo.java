package com.xp.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xp-zhao on 2018/5/24.
 */
public class ListDemo
{
	public static void main(String[] args)
	{
		System.out.println(String.valueOf((new Random().nextInt(8999) + 1000)));
		List<String> list = new ArrayList<>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");
		list.add("test5");
		System.out.println(list.size());
		System.out.println(list.subList(6, list.size()));
	}
}
