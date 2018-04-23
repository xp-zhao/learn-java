package com.xp.classinit;

/**
 * Created by xp-zhao on 2018/3/19.
 */
public class Derived extends Base
{
	/*2*/ static {System.out.println("Static Block 1");}

	private static String statciValue = Log.staticFieldInit();

	static {System.out.println("Static Block 2");}

	{System.out.println("Normal Block 1");}

	private String value=Log.fieldInit();

	{System.out.println("Normal Block 2");}

	Derived()
	{
		System.out.println("Derived Constructor");
	}

	public static void main(String[] args)
	{
//		Derived d = new Derived();
	}
}
