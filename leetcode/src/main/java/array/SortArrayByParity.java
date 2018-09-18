package array;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
   你可以返回满足此条件的任何数组作为答案。
	 输入：[3,1,2,4]
	 输出：[2,4,3,1]
	 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受
 * Created by xp-zhao on 2018/9/18.
 */
public class SortArrayByParity
{
	public static void main(String[] args)
	{
		int[] A = {3 , 1 , 4 , 2};
		int[] B = new int[A.length];
		int j = 0;
		for(int i = 0; i < A.length; i++){
			if(A[i] % 2 == 0){
				B[j] = A[i];
				j++;
			}
		}
		for(int i = 0; i < A.length; i++){
			if(A[i] % 2 != 0){
				B[j] = A[i];
				j++;
			}
		}
		System.out.println(Arrays.toString(B));
	}
}
