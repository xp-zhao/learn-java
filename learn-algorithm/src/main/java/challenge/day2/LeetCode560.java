package challenge.day2;

import cn.hutool.core.lang.Assert;
import java.util.HashMap;

/**
 * @author zhaoxiaoping
 * @date 2022-3-8
 */
public class LeetCode560 {
  public static void main(String[] args) {
    int[] nums = new int[] {1, 1, 1};
    Assert.isTrue(subSum(nums, 1) == 3);
    nums = new int[] {1, 2, 3};
    Assert.isTrue(subarraySum(nums, 3) == 2);
  }

  public static int subSum(int[] nums, int k) {
    int[] preSum = new int[nums.length + 1];
    preSum[0] = 0;
    for (int i = 1; i < preSum.length; i++) {
      preSum[i] = preSum[i - 1] + nums[i - 1];
    }
    int res = 0;
    for(int i = 1; i <= nums.length; i++) {
      for(int j = 0; j < i; j++){
        if(preSum[i] - preSum[j] == k){
          res++;
        }
      }
    }
    return res;
  }

  public static int subarraySum(int[] nums, int k) {
    int n = nums.length;
    HashMap<Integer, Integer> preSum = new HashMap<>();
    preSum.put(0, 1);
    int res = 0;
    int sum0 = 0;
    for (int i = 0; i < n; i++) {
      sum0 += nums[i];
      int sum1 = sum0 - k;
      if (preSum.containsKey(sum1)) {
        res += preSum.get(sum1);
      }
      preSum.put(sum0, preSum.getOrDefault(sum0, 0) + 1);
    }
    return res;
  }
}
