package challenge.day3;

import java.util.Arrays;

/**
 * 查分数组
 *
 * @author zhaoxiaoping
 * @date 2022-3-9
 */
public class Difference {
  private int[] diff;

  public Difference(int[] nums) {
    diff = new int[nums.length];
    diff[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      diff[i] = nums[i] - nums[i - 1];
    }
  }

  public void increment(int i, int j, int val) {
    diff[i] += val;
    for(int k : diff){
      
    }
    if (j + 1 < diff.length) {
      diff[j + 1] -= val;
    }
  }

  public int[] result() {
    int[] res = new int[diff.length];
    res[0] = diff[0];
    for (int i = 1; i < diff.length; i++) {
      res[i] = res[i - 1] + diff[i];
    }
    return res;
  }

  public static void main(String[] args) {
    Difference diff = new Difference(new int[] {8, 5, 9, 6, 1});
    diff.increment(1, 3, 1);
    System.out.println(Arrays.toString(diff.result()));
  }
}
