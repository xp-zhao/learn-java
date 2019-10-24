package core.modulo;

import org.junit.Test;

/**
 * ModuloOperation.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/24
 **/
public class ModuloOperation {

  @Test
  public void testModulo() {
    // the modulo operator compute remainder
    System.out.println(132 % 10);
    System.out.println(132 / 10);
  }

  @Test
  public void testIndex() {
    for (int i = 0; i < 20; i++) {
      System.out.println(i % 10);
    }
  }
}