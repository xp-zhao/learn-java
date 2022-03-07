package challenge.day1;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import java.util.Arrays;

/**
 * @author zhaoxiaoping
 * @date 2022-3-7
 */
public class LeetCode283 {
  public static void main(String[] args) {
    int[] nums = new int[] {0, 1, 0, 3, 12};
    moveZeroes(nums);
    Assert.isTrue(Arrays.equals(nums, new int[] {1, 3, 12, 0, 0}));
    nums = new int[] {0};
    moveZeroes(nums);
    Assert.isTrue(ArrayUtil.equals(nums, new int[] {0}));
  }

  public static void moveZeroes(int[] nums) {
    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[fast] != 0) {
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;
        slow++;
      }
      fast++;
    }
  }
}
