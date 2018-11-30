package array;

import java.util.Arrays;

/**
 * 832. 翻转图像
	 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
	 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
	 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

	 示例 1:
	 输入: [[1,1,0],[1,0,1],[0,0,0]]
	 输出: [[1,0,0],[0,1,0],[1,1,1]]
	 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
	 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]

	 示例 2:

	 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
	 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
	 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
	 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Created by xp-zhao on 2018/11/30.
 */
public class LeetCode_832_FlippingAnImage
{
	public static void main(String[] args) {
		int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
		print(A);
		System.out.println();
		int[][] result = flipAndInvertImage(A);
		print(result);
	}

	public static int[][] flipAndInvertImage(int[][] A) {
		int[][] result = new int[A.length][A[0].length];
		for(int i = 0; i < A.length; i++)
		{
			for(int j = 0; j < A[i].length; j++)
			{
				if(A[i][A[i].length - j - 1] == 0)
				{
					result[i][j] = 1;
				}else{
					result[i][j] = 0;
				}
			}
		}
		return result;
	}

	public static void print(int[][] nums){
		for(int[] num : nums)
		{
			System.out.println(Arrays.toString(num));
		}
	}
}
