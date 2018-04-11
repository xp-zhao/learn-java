package com.xp.Static;

/**
 * Created by xp-zhao on 2018/3/21.
 */
public class Person
{
	static
	{
		System.out.println("person static");
	}

	public Person(String str)
	{
		System.out.println("person "+str);
	}

}
