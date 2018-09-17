package com.xp.basics;

/**
 * Created by xp-zhao on 2018/9/4.
 */
public class Example
{
	private int x; //实例变量
	private static int y; // 静态变量
	public static void main(String[] args)
	{
		Example example = new Example();
		int x = example.x;
		int y = Example.y;
	}
}
