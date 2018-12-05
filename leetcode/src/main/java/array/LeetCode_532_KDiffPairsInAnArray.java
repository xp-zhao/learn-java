package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 532. 数组中的K-diff数对
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.

 示例 1:
 输入: [3, 1, 4, 1, 5], k = 2
 输出: 2
 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 尽管数组中有两个1，但我们只应返回不同的数对的数量。

 示例 2:
 输入:[1, 2, 3, 4, 5], k = 1
 输出: 4
 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。

 示例 3:
 输入: [1, 3, 1, 5, 4], k = 0
 输出: 1
 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 注意:

 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 数组的长度不超过10,000。
 所有输入的整数的范围在 [-1e7, 1e7]。
 * Created by xp-zhao on 2018/12/4.
 */
public class LeetCode_532_KDiffPairsInAnArray
{
	public static void main(String[] args){
		int[] nums1 = {3 , 1 , 4 , 1 , 5};
		int k1 = 2;
		System.out.println(findPairs(nums1,k1));
		System.out.println(findPairs1(nums1,k1));
		int[] nums2 = {1 , 2 , 3 , 4 , 5};
		int k2 = 1;
		System.out.println(findPairs(nums2,k2));
		System.out.println(findPairs1(nums2,k2));
		int[] nums3 = {1, 3, 1, 5, 4};
		int k3 = 0;
		System.out.println(findPairs(nums3,k3));
		System.out.println(findPairs1(nums3,k3));
	}

	public static int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		int count = 0;
		int temp;
		for(int i = 0; i < nums.length; i++)
		{
			if(i > 0 && nums[i] == nums[i - 1]){
				continue;
			}
			temp = nums[i] + k;
			for(int j = i + 1; j < nums.length; j++){
				if(temp == nums[j]){
					count++;
					break;
				}
			}
		}
		return count;
	}

	/**
	 * 其它解法
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findPairs1(int[] nums, int k) {
		if(k < 0){
			return 0;
		}
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++)
		{
			map.put(nums[i] , i);
		}
		for(int i = 0; i < nums.length; i++)
		{
			if(map.containsKey(nums[i] + k) && map.get(nums[i] + k) != i){
				count++;
				map.remove(nums[i] + k);
			}
		}
		return count;
	}
}
