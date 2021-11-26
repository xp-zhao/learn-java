package com.design.design_1_01;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回参数
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
@Data
@AllArgsConstructor
public class AwardRes {
  /** 描述 */
  private String info;
  /** 编码 */
  private String code;
}
