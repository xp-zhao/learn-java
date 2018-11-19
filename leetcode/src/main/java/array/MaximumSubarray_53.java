package array;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
         示例:
	 输入: [-2,1,-3,4,-1,2,1,-5,4],
	 输出: 6
	 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * Created by xp-zhao on 2018/11/19.
 */
public class MaximumSubarray_53
{
	public static void main(String[] args)
	{
//		int[] nums = {-2 , 1 , -3 , 4 , -1 , 2 , 1 , -5 , 4};
		int[] nums = {-2 , -1 , -3 };
		System.out.println(maxSubArray2(nums));
	}

	/**
	 * 解法1：暴力法（穷举）
	 * @param nums
	 * @return
	 */
	public static int maxSubArray1(int[] nums){
		int max = nums[0];
		int temp;
		for(int i = 0; i < nums.length; i++){
			for(int j = i; j < nums.length; j++){
				temp = 0;
				for(int k = i; k < j; k++){
					temp += nums[k];
					max = Math.max(max , temp);
				}
			}
		}
		return max;
	}

	/**
	 * 解法2：解法一的优化
	 * @param nums
	 * @return
	 */
	public static int maxSubArray2(int[] nums){
		int max = nums[0];
		int temp;
		for(int i = 0; i < nums.length; i++){
			temp = 0;
			for(int j = i; j < nums.length; j++){
				temp += nums[j];
				max = Math.max(max , temp);
			}
		}
		return max;
	}

	public static int maxSubArray(int[] nums) {
		int result = nums[0];
		int sum = 0;
		for(int i = 0; i < nums.length; i++){
			if(sum < 0){
				sum = nums[i];
			}else{
				sum += nums[i];
			}
			if(result < sum){
				result = sum;
			}
		}
		return result;
	}
}
