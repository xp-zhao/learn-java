package array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 566. 重塑矩阵
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
	 输入:
	 nums =
	 [[1,2],
	 [3,4]]
	 r = 1, c = 4
	 输出:
	 [[1,2,3,4]]
	 解释:
	 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵
 * Created by xp-zhao on 2018/9/18.
 */
public class ReshapeTheMatrix
{
	public static void main(String[] args)
	{
		int[][] nums = {{1 , 2} , {3 , 4},{5,6}};
		int row = nums.length;
		int col = nums[0].length;
		int r = 3;
		int c = 2;
		if(r * c != row * col){
			for(int i = 0; i < row; i++){
				System.out.println(Arrays.toString(nums[i]));
			}
		}
		int[][] result = new int[r][c];
		int k = 0,h = 0;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				result[k][h] = nums[i][j];
				h++;
				if(h == c){
					k++;
					h = 0;
				}
			}
		}
		for(int i = 0; i < result.length; i++){
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
