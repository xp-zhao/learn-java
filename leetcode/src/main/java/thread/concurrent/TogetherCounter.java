package thread.concurrent;

import thread.Counter;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by xp-zhao on 2018/12/12.
 */
public class TogetherCounter implements Counter
{
	private int familyMember;
	private ForkJoinPool pool;
	public static final int THRESHLOD = 24000;

	public TogetherCounter(){
		this.familyMember = 8;
		this.pool = new ForkJoinPool(this.familyMember);
	}

	public static void main(String[] args)
	{
		long length = (long) 1.2e8;
		int[] riceArray = FamilyCounter.createArray(length);
		Counter counter = new TogetherCounter();
		long startTime = System.currentTimeMillis();
		long value = counter.count(riceArray);
		long endTime = System.currentTimeMillis();
		System.out.println("协同操作消耗时间(毫秒)：" + (endTime - startTime) + ",数量：" + value);
	}

	private static class CounterRiceTask extends RecursiveTask<Long>{
		private int[] riceArray;
		private int from;
		private int to;

		public CounterRiceTask(int[] riceArray,int from,int to){
			this.riceArray = riceArray;
			this.from = from;
			this.to = to;
		}

		@Override
		protected Long compute()
		{
			long total = 0;
			if(to - from <= THRESHLOD){
				for(int i = from; i < to; i++){
					if(riceArray[i] == 1){
						total += 1;
					}
				}
				return total;
			}else{
				int mid = (from + to) / 2;
				CounterRiceTask left = new CounterRiceTask(riceArray , from , mid);
				left.fork();
				CounterRiceTask right = new CounterRiceTask(riceArray,mid + 1, to);
				right.fork();
				return left.join() + right.join();
			}
		}
	}

	@Override
	public long count(int[] riceArray)
	{
		return pool.invoke(new CounterRiceTask(riceArray,0,riceArray.length - 1));
	}
}
