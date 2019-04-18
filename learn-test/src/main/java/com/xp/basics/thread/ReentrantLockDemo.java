package com.xp.basics.thread;

/**
 * Created by xp-zhao on 2019/4/18.
 */
class Phone{
	public synchronized void sendSMS(){
		System.out.println(Thread.currentThread().getName()+"\t invoked sendSMS()");
		sendEmail();
	}
	public synchronized void sendEmail(){
		System.out.println(Thread.currentThread().getName()+"\t invoked sendEmail()");
	}
}

public class ReentrantLockDemo
{
	public static void main(String[] args) {
		Phone phone = new Phone();
		new Thread(() -> {
			phone.sendSMS();
		},"t1").start();

		new Thread(() -> {
			phone.sendSMS();
		},"t2").start();
	}
}
