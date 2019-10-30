package pattern.strategy;

import java.math.BigDecimal;

/**
 * ChristmasDiscounter.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class ChristmasDiscounter implements Discounter {

  @Override
  public BigDecimal applyDiscount(BigDecimal amount) {
    return amount.multiply(BigDecimal.valueOf(0.9));
  }
}