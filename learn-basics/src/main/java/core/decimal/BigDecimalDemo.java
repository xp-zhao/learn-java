package core.decimal;

import java.math.BigDecimal;

/**
 * @author zhaoxiaoping
 * @Description: 除法运算
 * @Date 2020/3/19
 **/
public class BigDecimalDemo {

  public static void main(String[] args) {
    BigDecimal b1 = BigDecimal.valueOf(10);
    BigDecimal b2 = BigDecimal.valueOf(3);
    System.out.println(b1.divide(b2, 4,BigDecimal.ROUND_HALF_UP).doubleValue());
    BigDecimal b3 = new BigDecimal("1");
    BigDecimal b4 = new BigDecimal("1.0");
    // false, 判断值和精度是否相同
    System.out.println(b3.equals(b4));
    // true, 判断值是否相同
    System.out.println(b3.compareTo(b4));
  }
}
