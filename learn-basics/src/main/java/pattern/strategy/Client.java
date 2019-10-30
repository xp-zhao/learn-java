package pattern.strategy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class Client {

  public static void main(String[] args) {
    Discounter easterDiscounter = new EasterDiscounter();

    BigDecimal discountedValue = easterDiscounter.applyDiscount(BigDecimal.valueOf(100));
    System.out.println(discountedValue);

    Discounter christmasDiscounter = new ChristmasDiscounter();
    BigDecimal value = christmasDiscounter.applyDiscount(BigDecimal.valueOf(100));
    System.out.println(value);

    List<Discounter> discounters = Arrays.asList(
        amount -> amount.multiply(BigDecimal.valueOf(0.9)),
        amount -> amount.multiply(BigDecimal.valueOf(0.7)),
        amount -> amount.multiply(BigDecimal.valueOf(0.5))
    );

    System.out.println(discounters.get(1).applyDiscount(BigDecimal.valueOf(100)));
  }
}