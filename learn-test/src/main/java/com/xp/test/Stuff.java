package com.xp.test;

/**
 * Created by xp-zhao on 2018/4/23.
 */
public class Stuff {
	public static void main(String[] args) {
		int input = 10;
		int step = 1;
		int count = 9;
		int result = 0;

		for (;input - count > 0; count*=10,step++){
			result += count * step;
			input -= count;
		}

		result += input * step;

		System.out.println(result);
	}
}
