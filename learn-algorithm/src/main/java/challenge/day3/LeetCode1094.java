package challenge.day3;

import cn.hutool.core.lang.Assert;

/**
 * @author zhaoxiaoping
 * @date 2022-3-9
 */
public class LeetCode1094 {
  public static void main(String[] args) {
    Assert.isFalse(carPooling(new int[][] {{2, 1, 5}, {3, 3, 7}}, 4));
    Assert.isTrue(carPooling(new int[][] {{2, 1, 5}, {3, 3, 7}}, 5));
    Assert.isTrue(carPooling(new int[][] {{2, 1, 5}, {3, 5, 7}}, 3));
    Assert.isTrue(carPooling(new int[][] {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11));
  }

  public static boolean carPooling(int[][] trips, int capacity) {
    int[] nums = new int[1001];
    Difference df = new Difference(nums);
    for (int[] trip : trips) {
      int val = trip[0];
      int i = trip[1];
      int j = trip[2] - 1;
      df.increment(i, j, val);
    }
    for (int i : df.result()) {
      if (capacity < i) {
        return false;
      }
    }
    return true;
  }
}
