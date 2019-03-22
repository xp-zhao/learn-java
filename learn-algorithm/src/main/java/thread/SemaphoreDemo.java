package thread;

import java.util.concurrent.Semaphore;

/**
 * 多线程顺序打印 ABC
 * Created by xp-zhao on 2019/3/22.
 */
public class SemaphoreDemo
{
	private int times;
	private Semaphore semaphoreA = new Semaphore(1);
	private Semaphore semaphoreB = new Semaphore(0);
	private Semaphore semaphoreC = new Semaphore(0);

	public SemaphoreDemo(int times){
		this.times = times;
	}

	public static void main(String[] args) {
		SemaphoreDemo client = new SemaphoreDemo(10);
		new Thread(client::printA).start();
		new Thread(client::printB).start();
		new Thread(client::printC).start();
	}

	public void printA(){
		try {
			print("A", semaphoreA, semaphoreB);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void printB(){
		try {
			print("B", semaphoreB, semaphoreC);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void printC(){
		try {
			print("C", semaphoreC, semaphoreA);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void print(String name, Semaphore current, Semaphore next) throws InterruptedException
	{
		for(int i = 0; i < times; i++){
			current.acquire();
			System.out.print(name);
			next.release();
		}
	}
}
