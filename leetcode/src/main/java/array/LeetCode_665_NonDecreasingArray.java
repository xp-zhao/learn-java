package array;

import org.junit.Assert;

/**
 * 665. 非递减数列
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。

 示例 1:
 输入: [4,2,3]
 输出: True
 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。

 示例 2:
 输入: [4,2,1]
 输出: False
 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * Created by xp-zhao on 2018/12/5.
 */
public class LeetCode_665_NonDecreasingArray
{
	public static void main(String[] args) {
		int[] nums1 = {2,2,3,4};
//		Assert.assertTrue(checkPossibility(nums1));
		int[] nums2 = {3,4,2,3};
		Assert.assertTrue(checkPossibility(nums2));
		int[] nums3 = {1 , 2 , 3 , 4 , 4 , 5 , 6};
//		Assert.assertTrue(checkPossibility(nums3));
		int[] nums4 = {2,3,3,2,1,2,3};
//		Assert.assertFalse(checkPossibility(nums4));
	}

	public static boolean checkPossibility(int[] nums) {
		boolean flag = false;
		for(int i = 0; i < nums.length - 1; i++)
		{
			if(nums[i] > nums[i + 1]){
				if(!flag){
					if(i >= 1){
						if(nums[i + 1] >= nums[i - 1]){
							nums[i] = nums[i + 1];
						}else{
							nums[i + 1] = nums[i];
						}
					}else{
						nums[i] = nums[i + 1];
					}
					flag = true;
				}else{
					return false;
				}
			}
		}
		return true;
	}
}
