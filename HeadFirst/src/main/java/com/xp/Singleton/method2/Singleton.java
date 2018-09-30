package com.xp.Singleton.method2;

/**
 * 单例：饿汉式-线程安全
 * Created by xp-zhao on 2018/9/30.
 */
public class Singleton
{
	private static Singleton instance = new Singleton();

	private Singleton(){

	}

	public static Singleton getInstance(){
		return instance;
	}
}
