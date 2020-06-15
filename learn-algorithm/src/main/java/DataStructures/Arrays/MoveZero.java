package DataStructures.Arrays;

import java.util.Arrays;

/**
 * @author zhaoxiaoping
 * @Description: 移动零
 * @Date 2020-6-15
 **/
public class MoveZero {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 0, 6, 0, 5};
    System.out.println(Arrays.toString(nums));
    move(nums);
    System.out.println(Arrays.toString(nums));
  }

  private static void move(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[j] = nums[i];
        if (i != j) {
          nums[i] = 0;
        }
        j++;
      }
    }
//    while (j < nums.length) {
//      nums[j] = 0;
//      j++;
//    }
  }
}
