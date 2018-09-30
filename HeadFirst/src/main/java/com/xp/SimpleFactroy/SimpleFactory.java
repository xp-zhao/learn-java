package com.xp.SimpleFactroy;

/**
 * 简单工厂模式
 * Created by xp-zhao on 2018/9/30.
 */
public class SimpleFactory
{
	public Product createProduct(int type){
		if(type == 1){
			return new ConcreteProduct1();
		}else if(type == 2){
			return new ConcreteProduct2();
		}
		return new ConcreteProduct();
	}
}
