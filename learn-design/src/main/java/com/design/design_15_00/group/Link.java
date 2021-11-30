package com.design.design_15_00.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 树节点链路
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
  /** 雇员ID */
  private String fromId;

  /** 雇员ID */
  private String toId;
}
