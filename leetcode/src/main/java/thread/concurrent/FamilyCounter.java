package thread.concurrent;

import thread.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by xp-zhao on 2018/10/30.
 */
public class FamilyCounter implements Counter
{
	private int familyMember;
	private ExecutorService pool;

	public FamilyCounter(){
		this.familyMember = 8;
		this.pool = Executors.newFixedThreadPool(this.familyMember);
	}

	public static void main(String[] args)
	{
		long length = (long) 1.2e8;
		int[] riceArray = createArray(length);
		Counter counter = new FamilyCounter();
		long startTime = System.currentTimeMillis();
		long value = counter.count(riceArray);
		long endTime = System.currentTimeMillis();
		System.out.println("八个人消耗时间(毫秒)：" + (endTime - startTime) + ", 数量" + value);
	}

	private static class CounterRiceTask implements Callable<Long>{
		private int[] riceArray;
		private int from;
		private int to;

		public CounterRiceTask(int[] riceArray,int from,int to)
		{
			this.riceArray = riceArray;
			this.from = from;
			this.to = to;
		}

		@Override
		public Long call() throws Exception
		{
			long total = 0;
			for(int i = from; i <= to; i++)
			{
				if(riceArray[i] == 1)
				{
					total += 1;
				}
				if(total >= 0.125e8)
				{
					break;
				}
			}
			return total;
		}
	}

	@Override
	public long count(int[] riceArray)
	{
		long total = 0;
		List<Future<Long>> results = new ArrayList<>();
		int part = riceArray.length / familyMember;
		for(int i = 0; i < familyMember; i++)
		{
			results.add(pool.submit(new CounterRiceTask(riceArray,i * part,(i + 1)*part)));
		}
		for(Future<Long> future : results)
		{
			try
			{
				total += future.get();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			catch (ExecutionException e)
			{
				e.printStackTrace();
			}
		}
		return total;
	}

	public static int[] createArray(long length)
	{
		int[] result = new int[(int) length];
		for(int i = 0; i < length; i++)
		{
			if(i % 1000000 == 0)
			{
				result[i] = 0;
			}else {
				result[i] = 1;
			}
		}
		return result;
	}
}
