package thread;

/**
 * 两个线程交替打印奇偶数
 * Created by xp-zhao on 2019/3/12.
 */
public class OddAndEven
{
	public static boolean flag = false;
	public static void main(String[] args) {
		Object lock = new Object();
		new Thread(()->{
			int i = 0;
			while(i <= 100){
				synchronized (lock){
					if(!flag){
						System.out.print(i+" ");
						flag = true;
						i += 2;
						lock.notify();
					}else{
						try
						{
							lock.wait();
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
			}
		},"odd").start();
		new Thread(()->{
			int i = 1;
			while(i <= 100){
				synchronized (lock){
					if(flag){
						System.out.print(i+" ");
						flag = false;
						i += 2;
						lock.notify();
					}else{
						try
						{
							lock.wait();
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
			}
		},"even").start();

	}
}
