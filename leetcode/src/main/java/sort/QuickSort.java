package sort;

import java.util.Arrays;

/**
 * 快速排序
 * Created by xp-zhao on 2018/9/29.
 */
public class QuickSort
{
	public static void main(String[] args)
	{
		int[] arr = {5 , 3 ,1, 7 , 4 , 9 , 2};
		sort(arr,0,arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int left, int right)
	{
		if(left < right)
		{
			int mark = position(arr,left,right);
			sort(arr,left,mark - 1);
			sort(arr,mark + 1,right);
		}
	}

	public static int position(int arr[], int left, int right)
	{
		int mark = arr[left]; // 选择第一个数为基准（基于这个数，将数组分为两部分，较小的在左边，较大的在右边）
		while(left < right)
		{
			while(left < right && arr[right] >= mark)
			{
				right--;
			}
			arr[left] = arr[right]; // 将小于基准值的数移到左边
			System.out.println("right: "+right+ " "+ Arrays.toString(arr));
			while(left < right && arr[left] <= mark)
			{
				left++;
			}
			arr[right] = arr[left]; // 将大于基准值的数移到右边
			System.out.println("left: "+ left + " " +Arrays.toString(arr));
		}
		arr[left] = mark;
		return left;
	}
}
