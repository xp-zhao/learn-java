package array;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 你找到的子数组应是最短的，请输出它的长度。

 示例 1:
 输入: [2, 6, 4, 8, 10, 9, 15]
 输出: 5
 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

 说明 :
 输入的数组长度范围在 [1, 10,000]。
 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * Created by xp-zhao on 2018/12/4.
 */
public class LeetCode_581_ShortestUnsortedContinuousSubarray
{
	public static void main(String[] args) {
		int[] nums = {2 , 6 , 4 , 8 , 10 , 9 , 15};
		System.out.println(findUnsortedSubarray(nums));
		int[] nums1 = {2 };
		System.out.println(findUnsortedSubarray(nums1));
		int[] nums2 = {4 , 8 , 10};
		System.out.println(findUnsortedSubarray(nums2));
		int[] nums3 = {2,3,3,2,4};
		System.out.println(findUnsortedSubarray(nums3));
		int[] nums4 = {4 , 8 , 10,10};
		System.out.println(findUnsortedSubarray(nums4));
	}

	/**
	 * 一次遍历，左、右同时进行；
	 左边前进记录当前经过元素的最大值，若按照升序规则，则当前遍历元素即为当前最大值；如果二者不相等，则用j记录当前前进的索引；
	 右边后退记录当前经过元素的最小值，按照升序规则，则当前遍历元素即为当前最小值；如果二者不相等，则用i记录当前后退的索引。
	 当一次遍历完成，前进的索引记录了不符合升序规则的最大索引，后退的索引记录了不符合规则的最小索引。
	 注意在给i和j赋初值的时候要考虑数组元素全部按升序排序的情况，返回为0。所以，赋值i和j为不大于0且相差1，如：i = 0, j = -1，或i = -1, j = -2
	 * @param nums
	 * @return
	 */
	public static int findUnsortedSubarray(int[] nums) {
		int beg = -1;
		int end = -2;
		int n = nums.length;
		int min = nums[n - 1];
		int max = nums[0];
		for(int i = 0; i < n; i++)
		{
			max = Math.max(max , nums[i]);
			min = Math.min(min , nums[n - i - 1]);
			if(nums[i] < max){
				end = i;
			}
			if(nums[n - 1 - i] > min){
				beg = n - 1 - i;
			}
		}
		return end - beg + 1;
	}
}
