package array;

import java.util.Arrays;

/**
 * 922. 按奇偶排序数组 II
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 你可以返回任何满足上述条件的数组作为答案。
 *
 *
 * 示例：
	 输入：[4,2,5,7]
	 输出：[4,5,2,7]
	 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * Created by xp-zhao on 2019/1/2.
 */
public class LeetCode_922_SortArrayByParitii
{
	public static void main(String[] args) {
		int[] nums = {4 , 2 , 5 , 7};
//		int[] nums = {3,4};
		System.out.println(Arrays.toString(sortArrayByParityII(nums)));
	}

	public static int[] sortArrayByParityII(int[] A) {
		int[] result = new int[A.length];
		for(int i = 0,j = 0,k = 1; i < A.length; i++){
//			if(A[i] % 2 == 0){
			if((A[i] & 1) == 0){ // 通过位运算判断奇偶性
				result[j] = A[i];
				j += 2;
			}else{
				result[k] = A[i];
				k += 2;
			}
		}
		return result;
	}
}
