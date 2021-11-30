package com.design.design_11_01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 库存
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
  /** 库存总量 */
  private int total;

  /** 库存已用 */
  private int used;
}
