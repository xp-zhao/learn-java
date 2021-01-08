package array;

import java.util.Arrays;

/** @author xp-zhao */
public class RotateArray {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 2;
    rotate(nums, k);
    System.out.println(Arrays.toString(nums));
  }

  public static void rotate(int[] nums, int k) {
    int len = nums.length;
    int[] newArr = new int[len];
    for (int i = 0; i < len; i++) {
      newArr[(i + k) % len] = nums[i];
    }
    System.arraycopy(newArr, 0, nums, 0, len);
  }
}
