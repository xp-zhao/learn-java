package challenge.day2;

import cn.hutool.core.lang.Assert;

/**
 * @author zhaoxiaoping
 * @date 2022-3-10
 */
public class LeetCode304 {
  public static void main(String[] args) {
    NumMatrix numMatrix =
        new NumMatrix(
            new int[][] {
              {3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}
            });
    Assert.isTrue(numMatrix.sumRegion(2, 1, 4, 3) == 8);
    Assert.isTrue(numMatrix.sumRegion(1, 1, 2, 2) == 11);
    Assert.isTrue(numMatrix.sumRegion(1, 2, 2, 4) == 12);
  }

  static class NumMatrix {
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
      int row = matrix.length;
      int column = matrix[0].length;
      if (row == 0 || column == 0) {
        return;
      }
      preSum = new int[row + 1][column + 1];
      for (int i = 1; i <= row; i++) {
        for (int j = 1; j <= column; j++) {
          preSum[i][j] =
              preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
        }
      }
    }

    public int sumRegion(int x1, int y1, int x2, int y2) {
      return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
    }
  }
}
