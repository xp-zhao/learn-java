package com.xp.Static;

import java.io.UnsupportedEncodingException;
import java.util.Stack;

/**
 * Created by xp-zhao on 2018/3/21.
 */
public class Test
{
	Person person = new Person("Test");

	static{
		System.out.println("test static");
	}

	public Test() {
		System.out.println("test constructor");
	}

	public static void main(String[] args) throws UnsupportedEncodingException
	{
//		new MyClass();
		MyClass myClass = new MyClass();
		MyClass myClass1 = new MyClass();
		System.out.println(myClass == myClass1);
		System.out.println(myClass.equals(myClass1));

		String str = "asdf";
		new String(str.getBytes("ISO8859-1"),"UTF-8");
		Stack<Integer> stack = new Stack<Integer>();

//		final StringBuffer a = new StringBuffer("asdf");
//		a = new StringBuffer("");
//		a.append("asdf");
//
//		String str = null;
//		if(str != null & !str.equals(""))
//		{
//			System.out.println("test");
//		}
	}
}
