package com.xp.TemplateMethod;

/**
 * Created by xp-zhao on 2018/11/20.
 */
public class Coffee extends CaffeineBeverage
{
	void brew()
	{
		System.out.println("Coffee.brew");
	}

	void addCondiments()
	{
		System.out.println("Coffee.addCondiments");
	}
}
