package com.xp.Decorator;

/**
 *  装饰者模式简单示例
 * Created by xp-zhao on 2018/12/13.
 */
public class Client
{
	public static void main(String[] args) {
		// 对下订单操作进行日志记录和性能统计
//		Command placeOrder = new LoggerDecorator(new PerformanceDecorator(new PlaceOrderCommand()));
		Command placeOrder = new PerformanceDecorator(new LoggerDecorator(new PlaceOrderCommand()));
		placeOrder.execute();
		System.out.println("-----------------------------------------------");
		// 对付款操作进行日志记录
		Command payment = new LoggerDecorator(new PaymentCommand());
		payment.execute();
	}
}
