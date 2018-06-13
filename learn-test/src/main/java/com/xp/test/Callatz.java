package com.xp.test;

/**
 * Created by xp-zhao on 2018/5/24.
 */
public class Callatz
{
	public static void main(String[] args)
	{
		fun(5);
	}

	public static void fun(int n)
	{
		int i = 0;
		while(true)
		{
			if(n % 2 == 0)
			{
				n = ((n * 3) + 1) /2 ;
			}
			else if(n == 1)
			{
				break;
			}
			else
			{
				n = n / 2;
			}
			i++;
		}
		System.out.println("sdf"+n);
	}
}
