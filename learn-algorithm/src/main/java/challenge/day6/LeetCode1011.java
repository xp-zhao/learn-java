package challenge.day6;

import cn.hutool.core.lang.Assert;

/**
 * @author zhaoxiaoping
 * @date 2022-3-25
 */
public class LeetCode1011 {
  public static void main(String[] args) {
    int[] weights = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Assert.isTrue(shipWithinDays(weights, 5) == 15);
  }

  public static int shipWithinDays(int[] weights, int days) {
    int left = 0;
    int right = 1;
    for (int w : weights) {
      left = Math.max(w, left);
      right += w;
    }
    while (left < right) {
      int mid = left + (right - left) / 2;
      int midValue = f(weights, mid);
      if (midValue == days) {
        right = mid;
      } else if (midValue < days) {
        right = mid;
      } else if (midValue > days) {
        left = mid + 1;
      }
    }
    return left;
  }

  /**
   * 定义: 当运载能力为 x 时,需要 f(x) 天运完所有货物
   *
   * @param weights 权重
   * @param x x
   * @return int
   */
  public static int f(int[] weights, int x) {
    int days = 0;
    for (int i = 0; i < weights.length;) {
      int cap = x;
      while (i < weights.length) {
        if (cap < weights[i]) {
          break;
        } else {
          cap -= weights[i];
          i++;
        }
      }
      days++;
    }
    return days;
  }
}
