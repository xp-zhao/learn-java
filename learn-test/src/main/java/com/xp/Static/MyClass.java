package com.xp.Static;

/**
 * Created by xp-zhao on 2018/3/21.
 */
public class MyClass extends Test
{
	Person person = new Person("MyClass");

	static
	{
		System.out.println("myclass static");
	}

	public MyClass()
	{
		System.out.println("myclass constructor");
	}

}
