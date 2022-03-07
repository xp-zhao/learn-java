package challenge.day1;

import cn.hutool.core.lang.Assert;

/**
 * @author zhaoxiaoping
 * @date 2022-3-7
 */
public class LeetCode27 {
  public static void main(String[] args) {
    int[] nums = new int[] {3, 2, 2, 3};
    Assert.isTrue(removeElement(nums, 3) == 2);
    nums = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
    Assert.isTrue(removeElement(nums, 2) == 5);
  }

  public static int removeElement(int[] nums, int val) {
    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    return slow;
  }
}
