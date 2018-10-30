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
					instance = new Singleton(); // 非原子操作
					// 1. 开辟一个空间
					// 2. 将空间赋值给变量
					// 3. 对这个空间进行初始化
				}
			}
		}
		return instance;
	}
}
