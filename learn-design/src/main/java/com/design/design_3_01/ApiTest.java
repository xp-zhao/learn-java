package com.design.design_3_01;

import java.math.BigDecimal;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class ApiTest {
  @Test
  public void test() {
    DecorationPackageController decoration = new DecorationPackageController();

    // 豪华欧式
    System.out.println(decoration.getMatterList(new BigDecimal("132.52"), 1));

    // 轻奢田园
    System.out.println(decoration.getMatterList(new BigDecimal("98.25"), 2));

    // 现代简约
    System.out.println(decoration.getMatterList(new BigDecimal("85.43"), 3));
  }
}
