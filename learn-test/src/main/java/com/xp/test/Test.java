package com.xp.test;

/**
 * Created by xp-zhao on 2018/2/12.
 */
public class Test
{
	private String str = "";

	public static void main(String[] args)
	{
//		System.out.println(reverse("xp"));
		String str = "param1=sdf";
//		String token = str.substring(str.indexOf("param1"), str.lastIndexOf("&"));
		String[] test = str.split("param1=|&");
		System.out.println("test");
//		System.out.println(token.substring(token.indexOf("=")+1));
	}

	public static String reverse(String str)
	{
		if(str.length() == 0)
		{
			return str;
		}
		else
		{
			return reverse(str.substring(1,str.length()) + str.substring(0,1));
		}
	}

	public void test()
	{
		String string = this.str;
	}
}
