package math;

/**
 * LeetCode_9_PalindromeNumber.java 判断一个整数是否是回文数
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/11
 **/
public class LeetCode_9_PalindromeNumber {

  public static void main(String[] args) {
    System.out.println(isPalindrome(10));
  }

  public static boolean isPalindrome(int x) {
    if(x < 0){
      return false;
    }
    int num = 0;
    int temp = x;
    while (x != 0) {
      num = num * 10 + x % 10;
      x = x / 10;
    }
    return temp == num;
  }
}