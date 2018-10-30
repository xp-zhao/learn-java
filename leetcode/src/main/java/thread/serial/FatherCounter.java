package thread.serial;

import thread.Counter;

/**
 * 并行的方式
 * Created by xp-zhao on 2018/10/30.
 */
public class FatherCounter implements Counter
{
	public static void main(String[] args)
	{
		long length = (long) 1.2e8;
		int[] riceArray = createArray(length);
		Counter counter = new FatherCounter();
		long startTime = System.currentTimeMillis();
		long value = counter.count(riceArray);
		long endTime = System.currentTimeMillis();
		System.out.println("消耗时间(毫秒)：" + (endTime - startTime));
	}

	@Override
	public long count(int[] riceArray)
	{
		long total = 0;
		for(int i : riceArray)
		{
			if(i == 1)
			{
				total += 1;
			}
			if(total > 1e8)
			{
				break;
			}
		}
		return total;
	}

	private static int[] createArray(long length)
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
