package com.xp.test;

import java.util.Scanner;

/**
 * Created by xp-zhao on 2018/5/29.
 */
public class Calculate
{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		System.out.println(get(i));
	}

	public static int get(int n)
	{
		int count = 0;
		while (n != 1 && n!=0) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = (3 * n + 1) / 2;
			}
			count = count + 1;
		}
		return count;
	}
}
