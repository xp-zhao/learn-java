package com.xp.creator.singleton.method1;

/**
 * 单例：懒汉式-线程不安全
 * Created by xp-zhao on 2018/9/30.
 */
public class Singleton
{
	private static Singleton instance;

	private Singleton(){

	}

	public static Singleton getInstance(){
		if(null == instance){
			instance = new Singleton();
		}
		return instance;
	}

	public static void main(String[] args)
	{
		Singleton singleton = Singleton.getInstance();
		Singleton singleton1 = Singleton.getInstance();
		System.out.println(singleton == singleton1);
	}
}
