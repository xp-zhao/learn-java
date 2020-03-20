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
  }
}
