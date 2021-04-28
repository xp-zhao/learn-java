package com.xp.creator.factorymethod;

/**
 * 工厂方法模式
 * Created by xp-zhao on 2018/9/30.
 */
public abstract class Factory
{
	public abstract Product factoryMethod();

	public void doSomething(){
		// do something with the product
	}
}
