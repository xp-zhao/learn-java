package array;

/**
 * 35. 搜索插入位置
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 你可以假设数组中无重复元素。

	 示例 1:
	 输入: [1,3,5,6], 5
	 输出: 2

	 示例 2:
	 输入: [1,3,5,6], 2
	 输出: 1

	 示例 3:
	 输入: [1,3,5,6], 7
	 输出: 4

	 示例 4:
	 输入: [1,3,5,6], 0
	 输出: 0
 * Created by xp-zhao on 2018/11/30.
 */
public class LeetCode_35_SearchInsertPosition
{
	public static void main(String[] args) {
		int[] nums = {1 , 3 , 5, 6};
		System.out.println(searchInsert(nums,2));
		int[] nums1 = {1 , 3};
		System.out.println(searchInsert(nums1,2));
		int[] nums2 = {1 , 3,5};
		System.out.println(searchInsert(nums1,4));
	}

	public static int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int middle = 0;
		if(target < nums[0]){
			return 0;
		}
		if(target > nums[right]){
			return nums.length;
		}
		while(left <= right){
//			middle = (left + right) / 2;
			middle = left + (right - left) / 2; // 可以防止 left + right 溢出
			if(nums[middle] > target){
				right = middle - 1;
			} else if (nums[middle] < target){
				left = middle + 1;
			} else{
				return middle;
			}
		}
		return left;
	}

}
