package challenge.day1;

import cn.hutool.core.lang.Assert;

/**
 * @author zhaoxiaoping
 * @date 2022-3-7
 */
public class LeetCode26 {
  public static void main(String[] args) {
    int[] nums = new int[] {1, 1, 2};
    Assert.isTrue(removeDuplicates(nums) == 2);
    nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    Assert.isTrue(removeDuplicates(nums) == 5);
  }

  public static int removeDuplicates(int[] nums) {
    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[slow] != nums[fast]) {
        slow++;
        nums[slow] = nums[fast];
      }
      fast++;
    }
    return slow + 1;
  }
}
