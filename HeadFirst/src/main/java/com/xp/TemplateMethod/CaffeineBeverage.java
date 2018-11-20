package com.xp.TemplateMethod;

/**
 * Created by xp-zhao on 2018/10/3.
 */
public abstract class CaffeineBeverage
{
	final void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	abstract void brew();
	abstract void addCondiments();
	void boilWater(){
		System.out.println("boilWater");
	}
	void pourInCup(){
		System.out.println("pourInCup");
	}
}
