package array;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 	输入: [0,1,0,3,12]
 	输出: [1,3,12,0,0]
 *
        必须在原数组上操作，不能拷贝额外的数组。
        尽量减少操作次数。
 * Created by xp-zhao on 2018/9/19.
 */
public class MoveZeroes
{
	public static void main(String[] args)
	{
		int[] arr = {0 , 1 , 0 , 3 , 12};
		moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 个人垃圾解法
	 * @param nums
	 */
	public static void moveZeroes(int[] nums) {
		long startTime = System.currentTimeMillis();
		int temp;
		for(int i = 0; i < nums.length - 1; i++){
			for(int j = 0; j < nums.length - i - 1; j++){
				if(nums[j] == 0) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	/**
	 * 优秀解法
	 * @param nums
	 */
	public static void moveZeroes2(int[] nums) {
		long startTime = System.currentTimeMillis();
		int count = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0){
				nums[count] = nums[i];
				count++;
			}
		}
		while(count < nums.length){
			nums[count] = 0;
			count++;
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
