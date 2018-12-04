package array;

/**
 * 414. 第三大的数
	 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

	 示例 1:
	 输入: [3, 2, 1]
	 输出: 1
	 解释: 第三大的数是 1.

	 示例 2:
	 输入: [1, 2]
	 输出: 2
	 解释: 第三大的数不存在, 所以返回最大的数 2 .

	 示例 3:
	 输入: [2, 2, 3, 1]
	 输出: 1
	 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
	 存在两个值为2的数，它们都排第二。
 * Created by xp-zhao on 2018/12/4.
 */
public class LeetCode_414_ThirdMaximumNumber
{
	public static void main(String[] args) {
		int[] nums1 = {1 , 2 , 3};
		System.out.println(thirdMax(nums1));
		int[] nums2 = {1 , 2};
		System.out.println(thirdMax(nums2));
		int[] nums3 = {2 , 2 , 1 , 1};
		System.out.println(thirdMax(nums3));
		int[] nums4 = {2 , 1 , Integer.MIN_VALUE};
		System.out.println(thirdMax(nums4));
	}

	public static int thirdMax(int[] nums) {
		if(nums.length == 1){
			return nums[0];
		}
		long max = Long.MIN_VALUE;
		long second = Long.MIN_VALUE;
		long third = Long.MIN_VALUE;
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] > max){
				third = second;
				second = max;
				max = nums[i];
			}else if(nums[i] < max && nums[i] > second){
				third = second;
				second = nums[i];
			}else if(nums[i] < second && nums[i] > third){
				third = nums[i];
			}
		}
		if(third == Long.MIN_VALUE){
			return (int) max;
		}else{
			return (int) third;
		}
	}
}
