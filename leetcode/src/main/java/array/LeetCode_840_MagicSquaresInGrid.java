package array;

/**
 * 840. 矩阵中的幻方
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 给定一个由整数组成的 N × N 矩阵，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。

 示例 1:
 输入: [[4,3,8,4],
 	[9,5,1,9],
 	[2,7,6,2]]
 输出: 1
 解释:
 下面的子矩阵是一个 3 x 3 的幻方：
 438
 951
 276

 而这一个不是：
 384
 519
 762

 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * Created by xp-zhao on 2018/12/4.
 */
public class LeetCode_840_MagicSquaresInGrid
{
	public static void main(String[] args) {
		int[][] grid = {{4 , 3 , 8 , 4} , {9 , 5 , 1 , 9} , {2 , 7 , 6 , 2}};
		int[][] grid1 = {{10 , 3 , 5} , {1 , 6 , 11} , {7 , 9 , 2}};
		System.out.println(numMagicSquaresInside(grid1));
	}

	public static int numMagicSquaresInside(int[][] grid) {
		int count = 0;
		int row = grid.length;
		int col = grid[0].length;
		int sum = 0;
		for(int i = 1; i < row - 1; i++){
			for(int j = 1; j < col - 1; j++){
				if(grid[i - 1][j - 1] > 9 || grid[i - 1][i + 1] > 9 || grid[i - 1][i] > 9 ||
					grid[i - 1][j - 1] <= 0 || grid[i - 1][i + 1] <=0 || grid[i - 1][i] <= 0 ||
					grid[i][j - 1] > 9 || grid[i][j] > 9 || grid[i][j + 1] > 9 ||
					grid[i][j - 1] <= 0 || grid[i][j] <= 0 || grid[i][j + 1] <= 0 ||
					grid[i + 1][j - 1] > 9 || grid[i + 1][j] > 9 || grid[i + 1][j + 1] > 9 ||
					grid[i + 1][j - 1] <= 0 || grid[i + 1][j] <= 0 || grid[i + 1][j + 1] <= 0)
				{
					continue;
				}
				sum = grid[i - 1][j - 1] + grid[i + 1][j + 1];
				if((grid[i - 1][j] + grid[i + 1][j]) == sum &&
					(grid[i][j + 1] + grid[i][j - 1]) == sum &&
					(grid[i - 1][j + 1] + grid[i + 1][j - 1]) == sum &&
					(grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] - grid[i][j]) == sum &&
					(grid[i - 1][j - 1] + grid[i + 1][j - 1] + grid[i][j - 1] - grid[i][j]) == sum &&
					(grid[i + 1][j + 1] + grid[i + 1][j] + grid[i + 1][j - 1] - grid[i][j]) == sum &&
					(grid[i + 1][j + 1] + grid[i][j + 1] + grid[i - 1][j + 1] - grid[i][j]) == sum){
					count++;
				}
			}
		}
		return count;
	}
}
