package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by xp-zhao on 2018/9/13.
 */
public class BubbleSort
{
	public static void main(String[] args)
	{
		int[] arr = {1 , 5 , 3 , 7 , 4 , 9 , 2};
		for(int i = 0; i < arr.length - 1; i++){
			for(int j = 0; j < arr.length - i - 1; j++){
				if(arr[j] > arr[j+1]){
					arr[j] = arr[j] ^ arr[j + 1];
					arr[j+1] = arr[j] ^ arr[j+1];
					arr[j] = arr[j] ^ arr[j+1];
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
