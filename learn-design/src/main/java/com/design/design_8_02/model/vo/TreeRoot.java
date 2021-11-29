package com.design.design_8_02.model.vo;

import lombok.Data;

/**
 * 规则树根节点
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Data
public class TreeRoot {
  /** 规则树ID */
  private Long treeId;

  /** 规则树根ID */
  private Long treeRootNodeId;

  /** 规则树名称 */
  private String treeName;
}
