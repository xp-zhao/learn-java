package challenge.day5;

import cn.hutool.core.lang.Assert;
import java.util.Arrays;

/**
 * @author zhaoxiaoping
 * @date 2022-3-11
 */
public class LeetCode34 {
  public static void main(String[] args) {
    Assert.isTrue(Arrays.equals(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8), new int[] {3, 4}));
    Assert.isTrue(Arrays.equals(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6), new int[] {-1, -1}));
    Assert.isTrue(Arrays.equals(searchRange(new int[] {}, 0), new int[] {-1, -1}));
  }

  public static int[] searchRange(int[] nums, int target) {
    int left = leftSearch(nums, target);
    if (left == -1) {
      return new int[] {-1, -1};
    }
    int right = rightSearch(nums, target);
    return new int[] {left, right};
  }

  public static int leftSearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      }
    }
    if (left >= nums.length || nums[left] != target) {
      return -1;
    }
    return left;
  }

  public static int rightSearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        left = mid + 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      }
    }
    if (right < 0 || nums[right] != target) {
      return -1;
    }
    return right;
  }
}
