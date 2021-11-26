package com.xp.duck.quack;

/**
 * Created by xp-zhao on 2018/4/16.
 */
public class MuteQuack  implements QuackBehavior
{
	public void quack()
	{
		System.out.println("<<Silence>>");
	}
}
