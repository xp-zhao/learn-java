package com.xp.climbStairs;

/**
 * Created by xp-zhao on 2018/4/27.
 * 一个楼梯有10级，每次走1级或两级，请问从底走到顶一共有多少种走法？
 */
public class climbStairsDemo
{
	public static void main(String[] args)
	{
//		System.out.println(climbStairs(60));
		int[] value = new int[71];
		System.out.println(climbStairs(70,value));
	}

	public static int climbStairs(int n)
	{
		if(n < 1)
		{
			return 0;
		}
		else if(n == 1)
		{
			return 1;
		}
		else if(n == 2)
		{
			return 2;
		}
		else
		{
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
	}

	public static int climbStairs(int n,int[] value)
	{
		if(value[n] != 0)
		{
			return value[n];
		}
		else
		{
			if(n < 1)
			{
				value[n] = 0;
			}
			else if(n == 1)
			{
				value[n] = 1;
			}
			else if(n == 2)
			{
				value[n] = 2;
			}
			else
			{
				value[n] = climbStairs(n - 1,value) + climbStairs(n - 2,value);
			}
			return value[n];
		}
	}
}
