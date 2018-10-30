package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆排序
 * Created by xp-zhao on 2018/10/19.
 */
public class HeapSort
{
	private int[] arr;

	public HeapSort(int[] arr)
	{
		this.arr = arr;
	}

	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		System.out.println(list.subList(0,3));
	}

}
