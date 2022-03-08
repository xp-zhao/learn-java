package challenge.day2;

import cn.hutool.core.lang.Assert;

/**
 * @author zhaoxiaoping
 * @date 2022-3-8
 */
public class LeetCode303 {
  public static void main(String[] args) {
    NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
    Assert.isTrue(numArray.sumRange(0, 2) == 1);
    Assert.isTrue(numArray.sumRange(2, 5) == -1);
    Assert.isTrue(numArray.sumRange(0, 5) == -3);
  }

  static class NumArray {
    private int[] preSum;

    public NumArray(int[] nums) {
      preSum = new int[nums.length + 1];
      for (int i = 1; i < preSum.length; i++) {
        preSum[i] = preSum[i - 1] + nums[i - 1];
      }
    }

    public int sumRange(int left, int right) {
      return preSum[right + 1] - preSum[left];
    }
  }
}
