package com.xp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xp-zhao on 2018/5/3.
 */
public class APP
{
	public static void main(String[] args)
	{
		try
		{
			String[] path = { "applicationContext.xml" };
			ApplicationContext act = new ClassPathXmlApplicationContext(path);
			if (act != null)
			{
				System.out.println("***************************************");
				System.out.println("|               程序启动完成                                          |");
				System.out.println("***************************************");
			}
		}
		catch (Exception e)
		{
			System.err.println("LJ！程序启动失败！");
			System.out.println("结束程序...");
			System.out.println("---------------");
			e.printStackTrace();
			return;
		}
	}
}
