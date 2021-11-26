package com.xp.creator.singleton.method3;

/**
 * 单例：懒汉式-线程安全
 * Created by xp-zhao on 2018/9/30.
 */
public class Singleton
{
	private static Singleton instance;

	private Singleton(){

	}

	public static synchronized Singleton getInstance(){
		if(null == instance){
			instance = new Singleton();
		}
		return instance;
	}
}
