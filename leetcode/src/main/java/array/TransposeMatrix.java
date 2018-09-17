package array;

import java.util.Arrays;

/**
 * 867. 转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
   矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引
	 输入：[[1,2,3],[4,5,6],[7,8,9]]
	 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * Created by xp-zhao on 2018/9/17.
 */
public class TransposeMatrix
{
	public static void main(String[] args)
	{
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		for(int i = 0; i < A.length; i++){
			System.out.println(Arrays.toString(A[i]));
		}
	}
}
