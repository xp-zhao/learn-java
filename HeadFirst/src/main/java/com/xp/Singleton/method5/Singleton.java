package com.xp.Singleton.method5;

/**
 * 单例：静态内部类实现
 * Created by xp-zhao on 2018/9/30.
 */
public class Singleton
{
	private Singleton(){

	}

	private static class SingletonHolder{
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}
}
