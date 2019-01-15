package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 找到所有出现两次的元素。
 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

 示例：

 输入:
 [4,3,2,7,8,2,3,1]

 输出:
 [2,3]
 * Created by xp-zhao on 2019/1/15.
 */
public class LeetCode_442_FindAllDuplicatesInAnArray
{
	public static void main(String[] args) {
		int[] nums = {4 , 3 , 2 , 7 , 8 , 2 , 3 , 1};
		System.out.println(findDuplicates(nums));
	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<>();
		// 将数组元素对应下标的值修改为本身的负数，若以当前元素为下标的数组的值为负数，则说明当前元素已经出现过一次。
		int index;
		for(int i = 0; i < nums.length; i++)
		{
			index = Math.abs(nums[i]) - 1;
			if(nums[index] < 0){
				list.add(index + 1);
			}else{
				nums[index] = -nums[index];
			}
		}
		return  list;
	}
}
