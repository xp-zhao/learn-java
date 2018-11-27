package com.xp.part2;

/**
 * Created by xp-zhao on 2018/11/27.
 */
public class AppleFancyFormatter implements AppleFormatter
{
	@Override
	public String accept(Apple apple)
	{
		String str = apple.getWeight() > 20 ? "heavy" : "light";
		return "A " + str + " " + apple.getColor() + " apple";
	}
}
