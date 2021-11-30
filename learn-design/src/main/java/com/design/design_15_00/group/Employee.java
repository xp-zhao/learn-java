package com.design.design_15_00.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 雇员
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
  /** ID */
  private String uId;

  /** 姓名 */
  private String name;

  /** 备注 */
  private String desc;
}
