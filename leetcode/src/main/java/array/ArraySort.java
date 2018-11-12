package array;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xp-zhao on 2018/11/7.
 */
public class ArraySort implements Runnable
{
	private int num;

	public ArraySort(int num)
	{
		this.num = num;
	}

	public static void main(String[] args)
	{
		int[] nums = {11 , 3 , 5 , 2 , 1 , 6 , 900};
		for(int i = 0; i < nums.length; i++)
		{
			new Thread(new ArraySort(nums[i])).start();
		}
	}

	@Override
	public void run()
	{
		try
		{
			Thread.sleep(num);
			System.out.println(num);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
