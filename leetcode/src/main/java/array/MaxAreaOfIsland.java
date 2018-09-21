package array;

/**
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * Created by xp-zhao on 2018/9/20.
 */
public class MaxAreaOfIsland
{
	public static void main(String[] args)
	{
		int[][] grid = {{0 , 0 , 1 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0} ,
			{0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 1 , 1 , 0 , 0 , 0} ,
			{0 , 1 , 1 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0} ,
			{0 , 1 , 0 , 0 , 1 , 1 , 0 , 0 , 1 , 0 , 1 , 0 , 0} ,
			{0 , 1 , 0 , 0 , 1 , 1 , 0 , 0 , 1 , 1 , 1 , 0 , 0} ,
			{0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0} ,
			{0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 1 , 1 , 0 , 0 , 0} ,
			{0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 1 , 0 , 0 , 0 , 0}};
		System.out.println(maxAreaOfIsland(grid));
	}

	public static int maxAreaOfIsland(int[][] grid)
	{
		int count = 0;
		int max = 0;
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				if(grid[i][j] == 1){
					max = Math.max(max , deepSearch(grid , i , j));
				}
			}
		}
		return max;
	}

	public static int deepSearch(int[][] grid , int i , int j)
	{
		if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1)
		{
			grid[i][j] = 0;
			int num = 1 + deepSearch(grid , i - 1 , j) + deepSearch(grid , i + 1 , j) +
				deepSearch(grid , i , j - 1) + deepSearch(grid , i , j + 1);
			return num;
		}else{
			return 0;
		}
	}
}
