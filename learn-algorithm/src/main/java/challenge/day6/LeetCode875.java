package challenge.day6;

/**
 * @author zhaoxiaoping
 * @date 2022-3-25
 */
public class LeetCode875 {
  public static void main(String[] args) {}

  public static int minEatingSpeed(int[] piles, int h) {
    int left = 1;
    int right = 1000000000 + 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      int pileMid = f(piles, mid);
      if (pileMid == h) {
        right = mid;
      } else if (pileMid < h) {
        right = mid;
      } else if (pileMid > h) {
        left = mid + 1;
      }
    }
    return left;
  }

  /**
   * 定义: 速度为 x 时, 需要 f(x) 吃完所有香蕉; f(x) 随着 x 单调递减
   *
   * @param piles 香蕉堆
   * @param x 速度
   * @return int 时间
   */
  private static int f(int[] piles, int x) {
    int hours = 0;
    for (int pile : piles) {
      hours += pile / x;
      if (pile % x != 0) {
        hours++;
      }
    }
    return hours;
  }
}
