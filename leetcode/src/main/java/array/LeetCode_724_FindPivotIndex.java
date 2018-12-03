package array;

/**
 * 724. 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

 示例 1:
 输入:
 nums = [1, 7, 3, 6, 5, 6]
 输出: 3
 解释:
 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 同时, 3 也是第一个符合要求的中心索引。

 示例 2:
 输入:
 nums = [1, 2, 3]
 输出: -1
 解释:
 数组中不存在满足此条件的中心索引。
 * Created by xp-zhao on 2018/12/3.
 */
public class LeetCode_724_FindPivotIndex
{
	public static void main(String[] args){
		int[] nums1 = {1 , 7 , 3 , 6 , 5 , 6};
		System.out.println(pivotIndex1(nums1));
		int[] nums2 = {1 , 2 , 3};
		System.out.println(pivotIndex1(nums2));
		int[] num3 = {-1 , -1 , -1 , -1 , -1 , 0};
		System.out.println(pivotIndex1(num3));
	}

	/**
	 *  错误解法（不能处理全为负数的情况）
	 * @param nums
	 * @return
	 */
	public static int pivotIndex(int[] nums) {
		if(nums.length == 0){
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		int sumLeft = nums[left];
		int sumRight = nums[right];
		while(left < right){
			if(nums[left] == 0){
				left++;
				sumLeft += nums[left];
			}
			if(nums[right] == 0){
				right--;
				sumRight += nums[right];
			}
			if(nums[left] < nums[right]|| sumLeft < sumRight){
				left++;
				sumLeft += nums[left];
			}else {
				right--;
				sumRight += nums[right];
			}
			if(sumLeft == sumRight && left == right){
				break;
			}
		}
		if(sumLeft == sumRight){
			return left;
		}
		return -1;
	}

	public static int pivotIndex1(int[] nums) {
		int sum = 0;
		for(int num : nums)
		{
			sum += num;
		}
		int leftSum = 0;
		for(int i = 0; i < nums.length; i++)
		{
			if(i == 0){
				leftSum = 0;
			}else{
				leftSum += nums[i - 1];
			}
			if(leftSum * 2 == sum - nums[i]){
				return i;
			}
		}
		return -1;
	}
}
