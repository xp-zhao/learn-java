package com.xp.basics.classinit;

/**
 * 派生类
 * Created by xp-zhao on 2019/3/20.
 */
public class Derived extends Base
{
	static {
		System.out.println("Static Block1");
	}

	private static String staticValue = Log.init("Static field");

	static{
		System.out.println("Static Block2");
	}

	{
		System.out.println("Normal Block1");
	}

	private String value = Log.init("Normal Field");

	{
		System.out.println("Normal Block2");
	}

	public Derived(){
		System.out.println("Derived Constructor");
	}

	public static void main(String[] args) {
		Derived derived = new Derived();
	}
}
