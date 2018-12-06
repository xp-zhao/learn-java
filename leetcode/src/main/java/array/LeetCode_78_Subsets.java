package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 	说明：解集不能包含重复的子集。

	 示例:

	 输入: nums = [1,2,3]
	 输出:
	 [
	 [3],
	 [1],
	 [2],
	 [1,2,3],
	 [1,3],
	 [2,3],
	 [1,2],
	 []
 	]
 * Created by xp-zhao on 2018/12/6.
 */
public class LeetCode_78_Subsets
{
	public static void main(String[] args) {
		int[] nums = {1 , 2 , 3};
		System.out.println(subsets(nums));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list;
		for(int i = 0; i < nums.length; i++)
		{
			list = new ArrayList<>();
			for(int j = i; j < nums.length; j++)
			{
				list.add(nums[j]);
			}
			result.add(list);
		}
		return result;
	}
}
