package array;

/**
 * 747. 至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 如果是，则返回最大元素的索引，否则返回-1。

 示例 1:
 输入: nums = [3, 6, 1, 0]
 输出: 1
 解释: 6是最大的整数, 对于数组中的其他整数,
 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.

 示例 2:
 输入: nums = [1, 2, 3, 4]
 输出: -1
 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 * Created by xp-zhao on 2018/12/3.
 */
public class LeetCode_747_LargestNumberAtLeastTwiceOfOthers
{
	public static void main(String[] args) {
		int[] nums1 = {3 , 6 , 1 , 0};
		System.out.println(dominantIndex(nums1));
		int[] nums2 = {1 , 2 , 3 , 4};
		System.out.println(dominantIndex(nums2));
		int[] nums3 = {6 , 1 , 8};
		System.out.println(dominantIndex(nums3));
		int[] nums4 = {0 , 0 , 3 , 2};
		System.out.println(dominantIndex(nums4));
	}

	public static int dominantIndex(int[] nums) {
		int max = nums[0];
		int index = 0;
		for(int i = 1; i < nums.length; i++)
		{
			if(nums[i] > max){
				max = nums[i];
				index = i;
			}
		}
		for(int i = 0; i < nums.length; i++){
			if(i != index && nums[i] * 2 > max){
				return -1;
			}
		}
		return index;
	}
}
