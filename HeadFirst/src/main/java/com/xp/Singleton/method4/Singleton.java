package com.xp.Singleton.method4;

/**
 * 单例：双重校验锁-线程安全
 * Created by xp-zhao on 2018/9/30.
 */
public class Singleton
{
	private volatile static Singleton instance;

	private Singleton(){

	}

	public static Singleton getInstance(){
		if(null == instance){
			synchronized (Singleton.class){
				if(null == instance){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
