package array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 	448. 找到所有数组中消失的数字
 *
 * 	 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
	 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
	 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

	 示例:
	 输入:
	 [4,3,2,7,8,2,3,1]
	 输出:
	 [5,6]

 * Created by xp-zhao on 2018/11/14.
 */
public class FindAllNumbers_448
{
	public static void main(String[] args)
	{
//		int[] nums = {4 , 3 , 2 , 7 , 8 , 2 , 3 , 1};
//		int[] nums = {2,2};
//		int[] nums = {5,4,6,7,9,3,10,9,5,6};
		int[] nums = {10,2,5,10,9,1,1,4,3,7};
		System.out.println(findDisappearedNumbers(nums));
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int index;
		for(int i = 0; i < nums.length; i++){
			index = Math.abs(nums[i]) - 1;
			if(nums[index] > 0){
				nums[index] = -nums[index];
			}
		}
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > 0){
				result.add(i + 1);
			}
		}
		return result;
	}
}
