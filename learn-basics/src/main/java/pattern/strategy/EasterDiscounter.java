package pattern.strategy;

import java.math.BigDecimal;

/**
 * EasterDiscounter.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class EasterDiscounter implements Discounter {

  @Override
  public BigDecimal applyDiscount(final BigDecimal amount) {
    return amount.multiply(BigDecimal.valueOf(0.5));
  }
}