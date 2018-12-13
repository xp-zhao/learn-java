package com.xp.Decorator;

/**
 *  用于性能统计的装饰器
 * Created by xp-zhao on 2018/12/13.
 */
public class PerformanceDecorator implements Command
{
	Command cmd;

	public PerformanceDecorator(Command cmd){
		this.cmd = cmd;
	}

	public void execute()
	{
		System.out.println("开始时间");
		this.cmd.execute();
		System.out.println("结束时间");
	}
}
