package com.xp.basics.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xp-zhao on 2019/4/18.
 */
class Phone implements Runnable{
	public synchronized void sendSMS(){
		System.out.println(Thread.currentThread().getName()+"\t invoked sendSMS()");
		sendEmail();
	}
	public synchronized void sendEmail(){
		System.out.println(Thread.currentThread().getName()+"\t invoked sendEmail()");
	}

	Lock lock = new ReentrantLock();

	@Override
	public void run()
	{

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
