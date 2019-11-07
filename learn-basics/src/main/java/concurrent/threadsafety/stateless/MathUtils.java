package concurrent.threadsafety.stateless;

import java.math.BigInteger;

/**
 * MathUtils.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/07
 **/
public class MathUtils {

  public static BigInteger factorial(int number) {
    BigInteger integer = new BigInteger("1");
    for (int i = 2; i < number; i++) {
      integer = integer.multiply(BigInteger.valueOf(i));
    }
    return integer;
  }
}