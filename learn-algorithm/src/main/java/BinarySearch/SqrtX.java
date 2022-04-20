package BinarySearch;

/**
 * @author zhaoxiaoping
 * @date 2022-4-20
 */
public class SqrtX {
  public static void main(String[] args) {
    int x = 2147395599;
    int left = 0;
    int right = x;
    int ans = -1;
    while (left <= right) {
      int mid = left + ((right - left) / 2);
      if ((long) mid * mid <= x) {
        ans = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    System.out.println(ans);
  }
}
