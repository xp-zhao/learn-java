package com.xp.Decorator;

/**
 * 用于日志记录的装饰器
 * Created by xp-zhao on 2018/12/13.
 */
public class LoggerDecorator implements Command
{
	Command cmd;

	public LoggerDecorator(Command cmd){
		this.cmd = cmd;
	}

	public void execute()
	{
		System.out.println("记录日志开始");
		this.cmd.execute();
		System.out.println("记录日志结束");
	}
}
