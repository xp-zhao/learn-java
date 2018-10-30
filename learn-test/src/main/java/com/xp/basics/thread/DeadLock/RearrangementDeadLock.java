package com.xp.basics.thread.DeadLock;

/**
 * Created by xp-zhao on 2018/10/9.
 */
public class RearrangementDeadLock
{
	private boolean flag = false;
	private int a = 1;
	private int result = -1;

	public void write(){
		a = 2;
		flag = true;
	}

	public void read()
	{
		if(flag){
			result = a * 3;
		}
		System.out.println("result: "+result);
	}

	private class ReadWriteThread extends Thread{
		private boolean flag;

		public ReadWriteThread(boolean flag){
			this.flag = flag;
		}

		@Override
		public void run(){
			if(flag){
				write();
			}else {
				read();
			}
		}
	}

	public static void main(String[] args)
	{
		RearrangementDeadLock deadLock = new RearrangementDeadLock();
		deadLock.new ReadWriteThread(true).start(); // 写
		deadLock.new ReadWriteThread(false).start(); // 读
	}
}
