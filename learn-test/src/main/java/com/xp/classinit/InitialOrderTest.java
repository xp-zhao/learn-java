package com.xp.classinit;

/**
 * Created by xp-zhao on 2018/3/19.
 */
public class InitialOrderTest
{
	public String field = method2();
	public static String staticField = method();

	// 静态初始化块
	static {
//		System.out.println(staticField);
		System.out.println("静态初始化块");
	}
	// 初始化块
	{
//		System.out.println(field);
		System.out.println("初始化块");
	}

	public InitialOrderTest()
	{
		System.out.println("构造器");
	}

	public static void main(String[] args)
	{
		new InitialOrderTest();
	}

	public static String method()
	{
		System.out.println("静态变量");
		return "静态变量";
	}
	public static String method2()
	{
		System.out.println("变量");
		return "变量";
	}
}
