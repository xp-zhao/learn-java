package com.xp.AbstractProduct;

/**
 * Created by xp-zhao on 2018/9/30.
 */
public class ConcreteFactory2 extends AbstractFactory
{
	AbstractProductA createProductA()
	{
		return new ProductA2();
	}

	AbstractProductB createProductB()
	{
		return new ProductB2();
	}
}
