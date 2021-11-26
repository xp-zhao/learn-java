package com.xp.struct.proxymode;

/**
 * Created by xp-zhao on 2018/10/30.
 */
public class DBQueryProxy implements IDBQuery
{
	private DBQuery real = null;

	public String request()
	{
		if(real == null)
		{
			real = new DBQuery();
		}
		return real.request();
	}

	public static void main(String[] args)
	{

	}
}
