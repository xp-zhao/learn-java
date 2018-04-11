package com.xp.classinit;

/**
 * Created by xp-zhao on 2018/3/19.
 */
public class Parent
{
	/* 静态变量 */
	public static String p_StaticField = method();
	/* 变量 */
	public String    p_Field = method2();
	protected int    i    = 9;
	protected int    j    = 0;
	/* 静态初始化块 */
	static {
//		System.out.println( p_StaticField );
		System.out.println( "父类--静态初始化块" );
	}
	/* 初始化块 */
	{
//		System.out.println( p_Field );
		System.out.println( "父类--初始化块" );
	}
	/* 构造器 */
	public Parent()
	{
		System.out.println( "父类--构造器" );
		System.out.println( "i=" + i + ", j=" + j );
		j = 20;
	}

	public static String method()
	{
		System.out.println("父类--静态变量");
		return "父类--静态变量";
	}

	public String method2()
	{
		System.out.println("父类--变量");
		return "父类--变量";
	}
}
