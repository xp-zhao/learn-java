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
		int[] nums = { 8,8,7,7,7 };
		System.out.println(majorityElement(nums));
		System.out.println(majorityElement2(nums));
	}

	/**
	 * 自己的解法
	 * @param nums
	 * @return
	 */
	public static int majorityElement(int[] nums) {
		long startTime = System.currentTimeMillis();
		int count = nums.length / 2;
		int size;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				size = map.get(nums[i]);
				size++;
				if(size > count){
					return nums[i];
				}
				map.put(nums[i] , size);
				continue;
			}
			map.put(nums[i] , 1);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		return nums[0];
	}

	/**
	 * 其它优秀解法
	 * @param nums
	 * @return
	 */
	public static int majorityElement2(int[] nums) {
		long startTime = System.currentTimeMillis();
		int result = nums[0];
		int count = 0;
		for(int num : nums){
			if(count == 0){
				result = num;
				count++;
			}else{
				if(result == num){
					count++;
				}else{
					count--;
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		return result;
	}
}
