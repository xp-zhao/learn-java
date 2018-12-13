package com.xp.Decorator;

/**
 * Created by xp-zhao on 2018/12/13.
 */
public class PlaceOrderCommand implements Command
{
	public void execute()
	{
		System.out.println("执行下订单的操作");
	}
}
