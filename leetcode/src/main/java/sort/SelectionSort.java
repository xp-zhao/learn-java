package sort;

import java.util.Arrays;

/**
 * 选择排序
 * Created by xp-zhao on 2018/9/13.
 */
public class SelectionSort
{
	public static void main(String[] args)
	{
		int[] arr = {1 , 5 , 3 , 7 , 4 , 9 , 2};
		int min,temp;
		for(int i = 0; i < arr.length - 1; i++){
			min = i;
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
