package com.xp.creator.singleton.method4;

/**
 * 单例：双重校验锁-线程安全
 * Created by xp-zhao on 2018/9/30.
 */
public class Singleton
{
	private volatile static Singleton instance;

	private Singleton(){
		System.out.println(Thread.currentThread().getName()+" 构造函数");
	}

	public static Singleton getInstance(){
		if(null == instance){
			synchronized (Singleton.class){
				if(null == instance){
					instance = new Singleton(); // 非原子操作
					// 1. 开辟一个空间 allocate();
					// 2. 将空间赋值给变量 instance(memory);
					// 3. 对这个空间进行初始化 instance = memory, 此时 instance != null;
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		// 单线程
//		System.out.println(Singleton.getInstance() == Singleton.getInstance());
//		System.out.println(Singleton.getInstance() == Singleton.getInstance());
//		System.out.println(Singleton.getInstance() == Singleton.getInstance());
		// 多线程
		for(int i = 1; i <= 10; i++)
		{
			new Thread(() -> Singleton.getInstance() ,String.valueOf(i)).start();
		}
	}
}
