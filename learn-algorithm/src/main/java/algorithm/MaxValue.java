package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaoxiaoping @Description: 01背包问题 @Date 2021-3-1
 */
public class MaxValue {

  public static void main(String[] args) {
    int[] weight = {1, 2, 3, 4};
    int[] value = {3, 4, 5, 6};
    int capacity = 7;
    System.out.println(maxValue(weight, value, capacity));
  }

  /** 用 dp[i][w] 表示在 i 个物品中，背包容量为 w 时的最大价值 */
  public static Integer maxValue(int[] weight, int[] value, int capacity) {
    int n = weight.length;
    int[][] dp = new int[n + 1][capacity + 1];
    for (int i = 1; i <= n; i++) {
      for (int w = 1; w <= capacity; w++) {
        if (weight[i - 1] > w) {
          dp[i][w] = dp[i - 1][w];
        } else {
          int a = dp[i - 1][w - weight[i - 1]] + value[i - 1];
          int b = dp[i - 1][w];
          if (a > b) {
            dp[i][w] = a;
          } else {
            dp[i][w] = b;
          }
        }
      }
    }
    return dp[n][capacity];
  }
}
