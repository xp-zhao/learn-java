package array;

/**
 * 152. 乘积最大子序列
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

 示例 1:
 输入: [2,3,-2,4]
 输出: 6
 解释: 子数组 [2,3] 有最大乘积 6。

 示例 2:
 输入: [-2,0,-1]
 输出: 0
 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * Created by xp-zhao on 2018/11/21.
 */
public class MaximumProductSubarray_152
{
	public static void main(String[] args)
	{
//		int[] nums = {2 , 3 , -2 , 4};
//		int[] nums = {-2 , 0 , -1};
//		int[] nums = {0,2};
		int[] nums = {3 , -1 , 4};
		System.out.println(maxProduct1(nums));
	}

	/**
	 * 暴力法（耗时较长）
	 * @param nums
	 * @return
	 */
	public static int maxProduct(int[] nums) {
		int result = nums[0];
		int product;
		for(int i = 0; i < nums.length; i++){
			product = 1;
			for(int j = i; j < nums.length; j++){
				product = product * nums[j];
				result = Math.max(result , product);
			}
		}
		return result;
	}

	public static int maxProduct1(int[] nums) {
		int result = nums[0];
		int product = 1;
		for(int i = 0; i < nums.length; i++){
			product = product * nums[i];
			if(product == 0){
				product = nums[i];
			}
			if(product < result){
				product = nums[i];
			}else{
				result = product;
			}
		}
		return result;
	}
}
