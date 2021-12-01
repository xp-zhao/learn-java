package com.design.design_19_00;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回对象
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
@Data
@AllArgsConstructor
public class Result {
  /** 编码 */
  private String code;
  /** 描述 */
  private String info;
}
