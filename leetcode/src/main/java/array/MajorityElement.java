package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 你可以假设数组是非空的，并且给定的数组总是存在众数
 输入: [3,2,3]
 输出: 3
 * Created by xp-zhao on 2018/9/18.
 */
public class MajorityElement
{
	public static void main(String[] args)
	{
		int[] nums = {3 , 2 , 3};
		System.out.println(majorityElement(nums));
	}

	public static int majorityElement(int[] nums) {
		int count = nums.length / 2;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){

			}
		}
		return 0;
	}
}
