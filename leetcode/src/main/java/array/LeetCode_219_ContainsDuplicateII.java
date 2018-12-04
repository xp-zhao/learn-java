package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

 示例 1:
 输入: nums = [1,2,3,1], k = 3
 输出: true

 示例 2:
 输入: nums = [1,0,1,1], k = 1
 输出: true

 示例 3:
 输入: nums = [1,2,3,1,2,3], k = 2
 输出: false
 * Created by xp-zhao on 2018/12/4.
 */
public class LeetCode_219_ContainsDuplicateII
{
	public static void main(String[] args) {
		int[] nums1 = {1 , 2 , 3 , 1};
		int k1 = 3;
		System.out.println(containsNearbyDuplicate(nums1,k1));
		System.out.println(containsNearbyDuplicate1(nums1,k1));
		int[] nums2 = {1 , 0 , 1 , 1};
		int k2 = 1;
		System.out.println(containsNearbyDuplicate(nums2,k2));
		System.out.println(containsNearbyDuplicate1(nums2,k2));
		int[] nums3 = {1 , 2 , 3 , 1 , 2 , 3};
		int k3 = 1;
		System.out.println(containsNearbyDuplicate(nums3,k3));
		System.out.println(containsNearbyDuplicate1(nums3,k3));
		int[] nums4 = {99 , 99};
		int k4 = 2;
		System.out.println(containsNearbyDuplicate(nums4,k4));
		System.out.println(containsNearbyDuplicate1(nums4,k4));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		int left = 0;
		int right = left + k;
		while(right < nums.length){
			if(nums[left] == nums[right]){
				return true;
			}
			left++;
			right++;
		}
		return false;
	}

	public static boolean containsNearbyDuplicate1(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++)
		{
			if(map.containsKey(nums[i])){
				if(i - map.get(nums[i]) <= k){
					return true;
				}else{
					map.put(nums[i] , i);
				}
			}else{
				map.put(nums[i] , i);
			}
		}
		return false;
	}
}
