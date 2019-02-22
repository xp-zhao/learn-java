package com.xp.thread;

/**
 * 由于指令重排的原因，b 可能为 1，a = 1 重排到了 if(flag) 前面
 * Created by xp-zhao on 2019/2/18.
 */
public class Reorder
{
	public static boolean flag = false;
	public static int a = 0;

	public static void main(String[] args) {

		new Thread(() -> {
			if(flag){
				a = 1;
			}
		}).start();
		new Thread(() -> {
			int b = a;
			System.out.println("b = " + b);
			flag = true;
		}).start();
	}
}
