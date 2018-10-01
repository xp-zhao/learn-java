package array;

/**
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
	 输入: [1,1,0,1,1,1]
	 输出: 3
	 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * Created by xp-zhao on 2018/10/1.
 */
public class MaxConsecutiveOnes
{
	public static void main(String[] args)
	{
		int[] nums = {1,1,0,1,1,1};
		System.out.println(findMaxConsecutiveOnes(nums));
	}

	public  static int findMaxConsecutiveOnes(int[] nums) {
		int max = 0,count = 0;
		for(int num : nums){
			if(num == 0){
				max = Math.max(max , count);
				count = 0;
				continue;
			}
			count++;
		}
		return Math.max(max,count);
	}
}
