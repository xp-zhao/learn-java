package BinarySearch;

/**
 * @description: 二分查找变种：查找最后一个小于等于给定值的元素
 * @author: zhaoxp
 * @create: 2019/05/14
 **/
public class BinarySearchFour {

  public static void main(String[] args) {
    int[] nums = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    System.out.println(search(nums, 18));
  }

  private static int search(int[] array, int value) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (array[mid] <= value) {
        if ((mid == array.length - 1) || (array[mid + 1] > value)) {
          return mid;
        } else {
          left = mid + 1;
        }
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}