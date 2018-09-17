package com.xp.basics;

import java.util.HashMap;

/**
 * Created by xp-zhao on 2018/9/3.
 */
public class Basics
{
	public static void main(String[] args)
	{
		StringTest();
	}

	public static void StringTest()
	{
		String a = new String("abc");
		String b = new String("abc");
		System.out.println(a == b);
		String x = a.intern();
		String y = a.intern();
		System.out.println(x == y);
	}

	public static void IntegerTest()
	{
		Integer x = new Integer(123);
		Integer y = new Integer(123);
		System.out.println(x == y);
		Integer a = Integer.valueOf(130);
		Integer b = Integer.valueOf(130);
		System.out.println(a == b);
		Integer i = 123;
		Integer j = 123;
		System.out.println(i == j);
		Integer c = 128;
		Integer d = 128;
		System.out.println(c == d);
	}

	public static void SwitchTest()
	{
		int i = 1;
		switch(i){
			case 1:
				System.out.println(1);
				break;
		}
	}
}
