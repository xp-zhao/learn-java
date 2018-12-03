package array;

/**
 * 674. 最长连续递增序列
	 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。

	 示例 1:
	 输入: [1,3,5,4,7]
	 输出: 3
	 解释: 最长连续递增序列是 [1,3,5], 长度为3。
	 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。

	 示例 2:
	 输入: [2,2,2,2,2]
	 输出: 1
	 解释: 最长连续递增序列是 [2], 长度为1。
	 注意：数组长度不会超过10000。
 * Created by xp-zhao on 2018/12/3.
 */
public class LeetCode_674_LongestContinuousIncreasingSubsequence
{
	public static void main(String[] args) {
		int[] nums1 = {1 , 3 , 5 , 7};
		System.out.println(findLengthOfLCIS(nums1));
		System.out.println(findLengthOfLCIS1(nums1));
		int[] nums2 = {2 , 2 , 2 , 2 , 2};
		System.out.println(findLengthOfLCIS(nums2));
		System.out.println(findLengthOfLCIS1(nums2));
	}

	public static int findLengthOfLCIS(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		int max = 1;
		int len = 1;
		for(int i = 1; i < nums.length; i++)
		{
			if(nums[i] > nums[i - 1]){
				len++;
			}else{
				max = Math.max(max , len);
				len = 1;
			}
		}
		return Math.max(max,len);
	}

	/**
	 * 其它解法
	 * @param nums
	 * @return
	 */
	public static int findLengthOfLCIS1(int[] nums) {
		int pre = Integer.MAX_VALUE;
		int count = 0;
		int result = 0;
		for(int num : nums)
		{
			if(num > pre){
				count++;
			}else{
				count = 1;
			}
			result = Math.max(result , count);
			pre = num;
		}
		return result;
	}


}
