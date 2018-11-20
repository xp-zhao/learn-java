package com.xp.TemplateMethod;

/**
 * Created by xp-zhao on 2018/11/20.
 */
public class Client
{
	public static void main(String[] args)
	{
		CaffeineBeverage caffeineBeverage = new Coffee();
		caffeineBeverage.prepareRecipe();
		System.out.println("-----------------------");
		caffeineBeverage = new Tea();
		caffeineBeverage.prepareRecipe();
	}
}
