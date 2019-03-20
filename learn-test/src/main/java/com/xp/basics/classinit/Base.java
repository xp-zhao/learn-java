package com.xp.basics.classinit;

/**
 * 基类
 * Created by xp-zhao on 2019/3/20.
 */
public class Base
{
	static{
		System.out.println("Base Static Block1");
	}

	private static String staticValue = Log.init("Base Static Field");

	static{
		System.out.println("Base Static Block2");
	}

	private String value = Log.init("Base Normal Field");

	{
		System.out.println("Base Normal Block");
	}

	public Base(){
		System.out.println("Base Constructor");
	}
}
