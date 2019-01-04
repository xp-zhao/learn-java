package DataStructures.Queue;

import java.util.Random;

/**
 * Created by xp-zhao on 2019/1/4.
 */
public class Main
{
	public static void main(String[] args) {
		int oprCount = 100000;
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
		double time1 = testQueue(arrayQueue , oprCount);
		System.out.println("ArrayQueue, time: " + time1 + " s");

		LoopQueue<Integer> loopQueue = new LoopQueue<>();
		double time2 = testQueue(loopQueue , oprCount);
		System.out.println("LoopQueue, time: " + time2 + " s");

		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
		double time3 = testQueue(linkedListQueue , oprCount);
		System.out.println("LinkedListQueue, time: " + time3 + " s");
	}

	private static double testQueue(Queue<Integer> queue,int oprCount){
		long startTime = System.nanoTime();
		Random random = new Random();
		for(int i = 0; i < oprCount; i++)
		{
			queue.enQueue(random.nextInt(Integer.MAX_VALUE));
		}
		for(int i = 0; i < oprCount; i++)
		{
			queue.deQueue();
		}
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1000000000.0;
	}
}
