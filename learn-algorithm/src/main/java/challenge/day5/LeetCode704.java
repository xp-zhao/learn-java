package challenge.day5;

import cn.hutool.core.lang.Assert;

/**
 * @author zhaoxiaoping
 * @date 2022-3-11
 */
public class LeetCode704 {
  public static void main(String[] args) {
    Assert.isTrue(search(new int[] {-1, 0, 3, 5, 9, 12}, 9) == 4);
    Assert.isTrue(search(new int[] {-1, 0, 3, 5, 9, 12}, 2) == -1);
  }

  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      }
    }
    return -1;
  }
}
