package com.xp.TemplateMethod;

/**
 * Created by xp-zhao on 2018/11/20.
 */
public class Tea extends CaffeineBeverage
{
	void brew()
	{
		System.out.println("Tea.brew");
	}

	void addCondiments()
	{
		System.out.println("Tea.addCondiments");
	}
}
