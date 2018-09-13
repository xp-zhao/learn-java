package com.xp.basics;

/**
 * Created by xp-zhao on 2018/9/4.
 */
public class PassByValue
{
	public static void main(String[] args)
	{
		Person person = new Person("xp");
		System.out.println(person);
		func(person);
		System.out.println(person);
		System.out.println(person.getName());

		func1(person);
		System.out.println(person.toString());
		System.out.println(person.getName());
	}

	private static void func(Person person)
	{
		System.out.println(person.toString());
		person = new Person("test");
		System.out.println(person.toString());
		System.out.println(person.getName());
	}

	private static void func1(Person person)
	{
		person.setName("B");
	}
}
