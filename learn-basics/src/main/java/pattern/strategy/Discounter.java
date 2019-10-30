package pattern.strategy;

import java.math.BigDecimal;

/**
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public interface Discounter{

  BigDecimal applyDiscount(BigDecimal amount);

  static Discounter christmasDiscounter() {
    return amount -> amount.multiply(BigDecimal.valueOf(0.9));
  }

  static Discounter newYearDiscounter() {
    return amount -> amount.multiply(BigDecimal.valueOf(0.7));
  }

  static Discounter easterDiscounter() {
    return amount -> amount.multiply(BigDecimal.valueOf(0.5));
  }
}
