package explore.interview.strings;

/**
 * @description: 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author: zhaoxp
 * @create: 2019/05/10
 **/
public class ReverseNumber {

  public static void main(String[] args) {
    int x = -120;
    System.out.println(reverse(x));
    System.out.println(reverse1(x));
  }

  /**
  * @Description: 个人解法，将数字转换为字符串，进行反转之后再转成数字（结果正确，但代码略长）
  * @Param:
  * @return:
  * @Author: zhaoxp
  * @Date: 2019/5/10
  */
  public static int reverse(int x) {
    // 标志是否是负数
    boolean flag = false;
    if(x < 0){
      flag = true;
      x = -x;
    }
    String str = String.valueOf(x);
    char[] s = str.toCharArray();
    int left = 0;
    int rigth = s.length - 1;
    char ch;
    while (left < rigth){
      ch = s[left];
      s[left] = s[rigth];
      s[rigth] = ch;
      left++;
      rigth--;
    }
    String result = new String(s);
    int r = 0;
    try {
      r = Integer.valueOf(result);
    } catch (Exception e){

    }
    if(flag){
      return -r;
    }
    return r;
  }

  /** 
  * @Description: 网上看到的解法，通过取余 % 获取末端的数字，通过除法 / 进行降位
  * @Param:
  * @return:
  * @Author: zhaoxp
  * @Date: 2019/5/10 
  */
  public static int reverse1(int x){
    long result = 0;
    while (x != 0){
      result = result * 10 + x % 10;
      x = x / 10;
    }
    if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
      return 0;
    }
    return (int) result;
  }
}