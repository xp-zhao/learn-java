package array;

import java.util.Arrays;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

 示例 1:
 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]

 示例 2:
 输入: [-1,-100,3,99] 和 k = 2
 输出: [3,99,-1,-100]
 解释:
 向右旋转 1 步: [99,-1,-100,3]
 向右旋转 2 步: [3,99,-1,-100]
 * Created by xp-zhao on 2018/12/3.
 */
public class LeetCode_189_RotateArray
{
	public static void main(String[] args) {
		int[] nums1 = {1 , 2 , 3 , 4 , 5 , 6 , 7};
		int k1 = 3;
		rotate1(nums1,k1);
		System.out.println(Arrays.toString(nums1));
		int[] nums2 = {3 , 99 , -1 , -100};
		int k2 = 2;
		rotate1(nums2,k2);
		System.out.println(Arrays.toString(nums2));
		int[] nums3 = {1 , 2 , 3 , 4};
		int k3 = 3;
		rotate1(nums3,k3);
		System.out.println(Arrays.toString(nums3));
	}

	public static void rotate(int[] nums, int k) {
		int count = 0;
		int temp;
		k = k % nums.length;
		while(count < k){
			count++;
			temp = nums[nums.length - 1];
			for(int i = nums.length - 1; i > 0; i--)
			{
				nums[i] = nums[i - 1];
			}
			nums[0] = temp;
		}
	}

	/**
	 * 其它解法
	 * @param nums
	 * @param k
	 */
	public static void rotate1(int[] nums,int k){
		k = k % nums.length;
		if(k == 0){
			return;
		}
		int[] temp = new int[k];
		for(int i = 0; i < k; i++)
		{
			temp[i] = nums[i];
		}
		int index;
		for(int i = nums.length - 1; i >= k; i--)
		{
			index = (i + k) % nums.length;
			nums[index] = nums[i];
		}
		for(int i = 0; i < temp.length; i++)
		{
			nums[(i + k) % nums.length] = temp[i];
		}
	}
}
