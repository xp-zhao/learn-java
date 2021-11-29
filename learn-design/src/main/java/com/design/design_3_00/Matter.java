package com.design.design_3_00;

import java.math.BigDecimal;

/**
 * 装修物料
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public interface Matter {
  /**
   * 场景；地板、地砖、涂料、吊顶
   *
   * @return {@code String}
   */
  String scene();

  /**
   * 品牌
   *
   * @return {@code String}
   */
  String brand();

  /**
   * 型号
   *
   * @return {@code String}
   */
  String model();

  /**
   * 平米报价
   *
   * @return {@code BigDecimal}
   */
  BigDecimal price();

  /**
   * 描述
   *
   * @return {@code String}
   */
  String desc();
}
