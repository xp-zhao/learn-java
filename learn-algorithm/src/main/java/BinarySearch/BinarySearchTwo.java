package BinarySearch;

/**
 * @description: 二分查找变种：查找最后一个值等于给定值的元素
 * @author: zhaoxp
 * @create: 2019/05/14
 **/
public class BinarySearchTwo {

  public static void main(String[] args) {
    int[] nums = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    System.out.println(search(nums, 8));
  }

  private static int search(int[] nums, int value) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right){
      int mid = left + ((right - left) >> 1);
      if(nums[mid] > value){
        right = mid - 1;
      }else if(nums[mid] < value){
        left = mid + 1;
      } else {
        if ((mid == nums.length - 1) || (nums[mid + 1] != value)){
          return mid;
        } else {
          left = mid + 1;
        }
      }
    }
    return -1;
  }
}