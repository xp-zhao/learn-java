package dp;

import java.util.Arrays;

/**
 * LeetCode_62_UniquePaths.java 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 *
 * 问总共有多少条不同的路径？
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/11
 **/
public class LeetCode_62_UniquePaths {

  public static void main(String[] args) {
    System.out.println(uniquePaths(7,3 ));
  }

  /**
   * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
   */
  public static int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    Arrays.fill(dp[0], 1);
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }


}