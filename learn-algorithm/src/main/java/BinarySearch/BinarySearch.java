package BinarySearch;

/** 二分查找算法（所查找的数组必须是有序的） 时间复杂度：O(logn) Created by xp-zhao on 2018/12/25. */
public class BinarySearch {

  public static void main(String[] args) {
    int[] sortedArrays = {3, 3, 3, 3, 4, 5, 6, 7};
    System.out.println(search(sortedArrays, 3));
    System.out.println(binarySearch(sortedArrays, 3));
    System.out.println(searchLeft(sortedArrays, 3));
    System.out.println(searchLeft01(sortedArrays, 3));
    System.out.println(searchLeft02(sortedArrays, 3));
    System.out.println(searchRight(sortedArrays, 3));
    System.out.println(searchRight01(sortedArrays, 3));
    System.out.println(searchRight02(sortedArrays, 3));
  }

  public static int search(int[] arrays, int value) {
    int left = 0;
    int right = arrays.length - 1;
    while (left <= right) {
      int middle = left + ((right - left) >> 1);
      if (arrays[middle] > value) {
        right = middle - 1;
      } else if (arrays[middle] < value) {
        left = middle + 1;
      } else {
        return middle;
      }
    }
    return -1;
  }

  public static int binarySearch(int[] arrays, int value) {
    int left = 0;
    int right = arrays.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arrays[mid] == value) {
        return mid;
      } else if (arrays[mid] < value) {
        left = mid + 1;
      } else if (arrays[mid] > value) {
        right = mid - 1;
      }
    }
    return -1;
  }

  public static int searchLeft(int[] arrays, int value) {
    int left = 0;
    int right = arrays.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arrays[mid] == value) {
        right = mid;
      } else if (arrays[mid] < value) {
        left = mid + 1;
      } else if (arrays[mid] > value) {
        right = mid;
      }
    }
    if (left == arrays.length || arrays[left] != value) {
      return -1;
    }
    return left;
  }

  public static int searchLeft01(int[] arrays, int value) {
    int left = 0;
    int right = arrays.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arrays[mid] == value) {
        right = mid - 1;
      } else if (arrays[mid] < value) {
        left = mid + 1;
      } else if (arrays[mid] > value) {
        right = mid - 1;
      }
    }
    if (left >= arrays.length || arrays[left] != value) {
      return -1;
    }
    return left;
  }

  public static int searchLeft02(int[] arrays, int value) {
    int left = 0;
    int right = arrays.length - 1;
    int res = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arrays[mid] >= value) {
        res = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return res;
  }

  public static int searchRight(int[] arrays, int value) {
    int left = 0;
    int right = arrays.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arrays[mid] == value) {
        left = mid + 1;
      } else if (arrays[mid] < value) {
        left = mid + 1;
      } else if (arrays[mid] > value) {
        right = mid;
      }
    }
    if (left == 0 || arrays[left - 1] != value) {
      return -1;
    }
    return left - 1;
  }

  public static int searchRight01(int[] arrays, int value) {
    int left = 0;
    int right = arrays.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arrays[mid] == value) {
        left = mid + 1;
      } else if (arrays[mid] < value) {
        left = mid + 1;
      } else if (arrays[mid] > value) {
        right = mid - 1;
      }
    }
    if (right < 0 || arrays[right] != value) {
      return -1;
    }
    return right;
  }

  public static int searchRight02(int[] arrays, int value) {
    int left = 0;
    int right = arrays.length - 1;
    int res = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if(arrays[mid] <= value){
        res = mid;
        left = mid + 1;
      }else{
        right = mid - 1;
      }
    }
    return res;
  }
}
