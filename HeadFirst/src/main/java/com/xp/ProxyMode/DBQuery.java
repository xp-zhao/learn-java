package com.xp.ProxyMode;

/**
 * Created by xp-zhao on 2018/10/30.
 */
public class DBQuery implements IDBQuery
{
	public DBQuery()
	{
		try
		{
			Thread.sleep(1000); // 模拟数据库连接等耗时操作
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public String request()
	{
		return "request string";
	}
}
