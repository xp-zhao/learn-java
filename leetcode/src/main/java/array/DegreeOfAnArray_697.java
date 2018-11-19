package array;

import java.util.*;

/**
 * 697. 数组的度
 *
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
	 示例 1:
	 输入: [1, 2, 2, 3, 1]
	 输出: 2
	 解释:
	 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
	 连续子数组里面拥有相同度的有如下所示:
	 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
	 最短连续子数组[2, 2]的长度为2，所以返回2.

	 示例 2:
	 输入: [1,2,2,3,1,4,2]
	 输出: 6
 *
 * Created by xp-zhao on 2018/11/16.
 */
public class DegreeOfAnArray_697
{
	public static void main(String[] args)
	{
//		int[] nums = {1 , 2 , 2 , 3 , 1};
//		int[] nums = {1 , 2 , 2 , 3 , 1, 4, 2};
		int[] nums = {2 , 1};
		System.out.println(findShortestSubArray1(nums));
	}

	/**
	 * 个人解法 (耗时较长)
	 * @param nums
	 * @return
	 */
	public static int findShortestSubArray(int[] nums) {
		int size;
		int min = nums.length;
		int max = 0;
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums){
			if(map.containsKey(num)){
				map.put(num,map.get(num)+1);
			}else{
				map.put(num , 1);
			}
			max = Math.max(max , map.get(num));
		}
		int number;
		for(int i = 0; i < nums.length - 1; i++){
			size = i;
			number = 1;
			if(set.add(nums[i])){
				for(int j = i + 1; j < nums.length; j++){
					if(nums[j] == nums[i]){
						size = j;
						number++;
					}
				}
				if(max == number){
					min = Math.min(min,size - i + 1);
				}
			}
		}
		return min;
	}

	/**
	 * 耗时较短的解法
	 * @param nums
	 * @return
	 */
	public static int findShortestSubArray1(int[] nums) {
		// 找出数组最大值
		int maxNum = nums[0];
		for(int i = 0; i < nums.length; i++){
			maxNum = Math.max(maxNum , nums[i]);
		}
		int max = 1; // 记录最大的度
		int[] start = new int[maxNum + 1]; // 记录起始位置
		int[] length = new int[maxNum + 1]; // 记录长度
		int[] count = new int[maxNum + 1]; // 记录度
		for(int i = 0; i < nums.length; i++){
			count[nums[i]]++;
			if(count[nums[i]] == 1){
				start[nums[i]] = i;
			}else{
				length[nums[i]] = i - start[nums[i]] + 1;
				max = Math.max(max,count[nums[i]]);
			}
		}
		if(max == 1){
			return 1;
		}
		int degree = nums.length;
		for(int i = 0; i <= maxNum; i++){
			if(max == count[i]){
				degree = Math.min(length[i] , degree);
			}
		}
		return degree;
	}
}
