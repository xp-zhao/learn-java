package explore.interview.strings;

/**
 * @description: 字符串转整数
 * @author: zhaoxp
 * @create: 2019/05/10
 **/
public class Atoi {

  public static void main(String[] args) {
    String str = "  -42";
    System.out.println(str.trim());
  }

  public static int myAtoi(String str) {
    if (str.trim().equals("")) {
      return 0;
    }
    char c = str.trim().charAt(0);
    if (c >= 'a' && c <= 'z') {
      return 0;
    }

    return 0;
  }

}