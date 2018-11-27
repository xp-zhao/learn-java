package com.xp.part1;

/**
 * Created by xp-zhao on 2018/11/27.
 */
public class AppleDemo
{
	public static void main(String[] args) {
		Apple apple = new Apple("green" , 20);
		System.out.println(apple);
		GreenApple greenApple = (GreenApple) apple;
		System.out.println(greenApple);
	}
}
