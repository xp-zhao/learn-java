package utils;

/** @author zhaoxiaoping @Description: 示例程序 @Date 2021-10-26 */
public class Example {
  public static void main(String[] args) {
    String str = "2019年5月第六十九次印刷";
    str = str.substring(str.indexOf("第") + 1, str.indexOf("次"));
    System.out.println(StrUtil.chineseNumber2Int(""));
  }
}
