package com.xp.creator.factorymethod;

/**
 * Created by xp-zhao on 2018/9/30.
 */
public class ConcreteFactory2 extends Factory implements Product
{
	public Product factoryMethod()
	{
		return new ConcreteFactory2();
	}
}
