package com.xp.classinit;

/**
 * Created by xp-zhao on 2018/3/19.
 */
public class SubClass extends Parent
{
	/* 静态变量 */
	public static String s_StaticField = method3();
	/* 变量 */
	public String s_Field = method4();
	/* 静态初始化块 */
	static {
//		System.out.println( s_StaticField );
		System.out.println( "子类--静态初始化块" );
	}
	/* 初始化块 */
	{
//		System.out.println( s_Field );
		System.out.println( "子类--初始化块" );
	}
	/* 构造器 */
	public SubClass()
	{
		System.out.println( "子类--构造器" );
		System.out.println( "i=" + i + ",j=" + j );
	}


	/* 程序入口 */
	public static void main( String[] args )
	{
		System.out.println( "子类main方法" );
		new SubClass();
	}

	public static String method3()
	{
		System.out.println("子类--静态变量");
		return "子类--静态变量";
	}

	public String method4()
	{
		System.out.println("子类--变量");
		return "子类--变量";
	}
}
