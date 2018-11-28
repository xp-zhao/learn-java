package com.xp.part3;

/**
 * Created by xp-zhao on 2018/11/28.
 */
public class Test
{
	public static void main(String[] args) {
		Runnable r1 = () -> System.out.println("hello 1");
		Runnable r2 = new Runnable()
		{
			@Override public void run()
			{
				System.out.println("hello 2");
			}
		};
		process(r1);
		process(r2);
		process(() -> System.out.println("hello 3"));
	}

	public static void process(Runnable runnable){
		runnable.run();
	}
}
