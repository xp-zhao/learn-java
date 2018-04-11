package com.xp.test;

/**
 * Created by xp-zhao on 2018/3/19.
 */
public class A
{
	public int i = method();
	public static int j = method2();
	public int k = 0;

	public A()
	{
		System.out.println(1);
	}

	public static int method()
	{
		System.out.println(2);
		return 2;
	}

	public static int method2()
	{
		System.out.println(3);
		return 3;
	}

}
