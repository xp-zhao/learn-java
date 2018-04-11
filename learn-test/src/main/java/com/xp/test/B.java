package com.xp.test;

/**
 * Created by xp-zhao on 2018/3/19.
 */
public class B extends A
{
	public int i = method3();
	public static int n = method4();
	public int j = 0;

	public B()
	{
		System.out.println(4);
	}

	public static int method3()
	{
		System.out.println(5);
		return 5;
	}

	public static int method4()
	{
		System.out.println(6);
		return 6;
	}

	public static void main(String[] args)
	{
		System.out.println(7);
		A a = new B();
	}
}
