package array;

import org.junit.Assert;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 将图像顺时针旋转 90 度。

 说明：
 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * Created by xp-zhao on 2019/1/22.
 */
public class LeetCode_48_RotateImage
{
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		rotate(matrix);
		Assert.assertArrayEquals(new int[][]{
			{7, 4, 1},
			{8, 5, 2},
			{9, 6, 3}
		}, matrix);
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n / 2; i++){
			for(int j = i; j < n - i - 1; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}
	}
}
