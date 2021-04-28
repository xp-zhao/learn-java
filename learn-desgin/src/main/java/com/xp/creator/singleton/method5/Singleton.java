package com.xp.creator.singleton.method5;

/**
 * 单例：静态内部类实现
 * 只有在访问 getInstance 方法时，程序才会访问 SingletonHolder.INSTANCE,
 * 才会触发对 SingletonHolder 的初始化，由于内初始化是线程安全的，且只会执行一次，
 * 因此可以保证多线程环境下有且仅有一个 Singleton 实例
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
