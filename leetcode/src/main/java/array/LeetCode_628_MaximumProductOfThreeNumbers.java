package array;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

 示例 1:
 输入: [1,2,3]
 输出: 6

 示例 2:
 输入: [1,2,3,4]
 输出: 24
 * Created by xp-zhao on 2018/12/2.
 */
public class LeetCode_628_MaximumProductOfThreeNumbers
{
	public static void main(String[] args){
		int[] nums1 = {1 , 2 , 3};
		System.out.println(maximumProduct(nums1));
		int[] nums2 = {1 , 2 , 3 , 4};
		System.out.println(maximumProduct(nums2));
	}

	public  static int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		if(nums.length <= 3){
			return nums[0] * nums[1] * nums[2];
		}
		if(nums[1] < 0){
			return Math.max(nums[0] * nums[1] * nums[nums.length - 1] , nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
		}else{
			return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
		}
	}
}
