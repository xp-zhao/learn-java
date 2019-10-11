package string;

/**
 * LeetCode_8_StringToInteger.java 字符串转整数
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/11
 **/
public class LeetCode_8_StringToInteger {

  public static void main(String[] args) {
    System.out.println(myAtoi("-91283472332"));
  }

  public static int myAtoi(String str) {
    // 去掉首尾的空格，并全部转为小写
    str = str.trim().toLowerCase();
    char[] chars = str.toCharArray();
    if (chars.length == 0 || (chars[0] >= 'a' && chars[0] <= 'z')) {
      return 0;
    }
    long num = 0;
    // 是否为正数
    boolean flag = true;
    if (chars[0] == '+') {
      chars[0] = '0';
    }
    if (chars[0] == '-') {
      chars[0] = '0';
      flag = false;
    }
    for (char item : chars) {
      if (item < '0' || item > '9') {
        break;
      }
      int i = (char) (item - '0');
      num = num * 10 + i;
      if (flag && num > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (!flag && -num < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
    }
    if (!flag) {
      num = -num;
    }
    return (int) num;
  }
}