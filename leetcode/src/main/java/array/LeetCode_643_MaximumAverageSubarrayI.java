package array;

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

 示例 1:
 输入: [1,12,-5,-6,50,3], k = 4
 输出: 12.75
 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * Created by xp-zhao on 2018/12/4.
 */
public class LeetCode_643_MaximumAverageSubarrayI
{
	public static void main(String[] args) {
		int[] nums = {1 , 12 , -5 , -6 , 50 , 3};
		int k = 4;
		System.out.println(findMaxAverage(nums,k));
		int[] nums1 = {5};
		int k1 = 1;
		System.out.println(findMaxAverage(nums1,k1));
		int[] nums2 = {0,1,1,3,3};
		int k2 = 4;
		System.out.println(findMaxAverage(nums2,k2));
	}

	public static double findMaxAverage(int[] nums, int k) {
		double sum = 0;
		for(int i = 0; i < k; i++){
			sum += nums[i];
		}
		double max = sum;
		for(int i = k; i < nums.length; i++)
		{
			sum = sum - nums[i - k] + nums[i];
			max = Math.max(max , sum);
		}
		return max / k;
	}
}
