package array;

import java.util.Arrays;

/**
 * 	167. 两数之和 II - 输入有序数组
 *
 * 	 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
	 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

	 说明:
	 返回的下标值（index1 和 index2）不是从零开始的。
	 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

	 示例:
	 输入: numbers = [2, 7, 11, 15], target = 9
	 输出: [1,2]
	 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * Created by xp-zhao on 2018/11/14.
 */
public class TwoSum_167
{
	public static void main(String[] args)
	{
		int[] nums = {2 , 7 , 11 , 15};
		int target = 9;
		System.out.println(Arrays.toString(towSum1(nums,target)));
	}

	/**
	 * 暴力解法
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] towSum(int[] nums,int target)
	{
		int[] result = new int[2];
		for(int i = 0; i < nums.length - 1; i++){
			for(int j = i + 1; j < nums.length; j++){
				if(nums[i] + nums[j] == target){
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				}
			}
		}
		return result;
	}

	/**
	 * 优质解法
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] towSum1(int[] nums, int target){
		int[] result = new int[2];
		int left = 0;
		int right = nums.length - 1;
		int sum;
		while(left < right){
			sum = nums[left] + nums[right];
			if(sum > target){
				right--;
			}else if(sum < target){
				left++;
			}else{
				result[0] = left + 1;
				result[1] = right + 1;
				break;
			}
		}
		return result;
	}
}
