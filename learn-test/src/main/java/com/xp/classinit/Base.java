package com.xp.classinit;

/**
 * Created by xp-zhao on 2018/3/19.
 */
public class Base
{
	static {
		System.out.println("Base Static Block 1");
	}

	private static String staticValue = Log.baseStaticFieldInit();

	static{
		System.out.println("Base Static Block 2");
	}

	{
		System.out.println("Base Normal Block 1");
	}

	private String value = Log.baseFieldInit();

	{
		System.out.println("Base Normal Block 2");
	}
	Base(){
		System.out.println("Base Constructor");
	}

	public static void main(String[] args)
	{
		int i = 0;
		int j = i++;
//		for(int j = 0; j < 100; j++)
//		{
//			i = i++;
////			System.out.println(i);
//		}
//		System.out.println(i);
		System.out.println(i + " "+ j );
	}

}
