package com.xp.basics.thread;

/**
 * Created by xp-zhao on 2018/9/14.
 */
public class SynchronizedExample
{
	public void func(){
		synchronized (SynchronizedExample.class){
			for(int i = 0; i < 10; i++){
				System.out.print(i+" ");
			}
		}
	}
}
