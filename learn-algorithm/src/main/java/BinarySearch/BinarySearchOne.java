package BinarySearch;

/**
 * @description: 二分查找变体：查找第一个值等于给定值的元素
 * @author: zhaoxp
 * @create: 2019/05/14
 **/
public class BinarySearchOne {

  public static void main(String[] args) {
    int[] nums = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    System.out.println(search(nums, 8));
  }

  public static int search(int[] arrays, int value) {
    int left = 0;
    int right = arrays.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (arrays[mid] > value) {
        right = mid - 1;
      } else if (arrays[mid] < value) {
        left = mid + 1;
      } else {
        if((mid == 0) || (arrays[mid - 1] != value)){
          return mid;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}