package com.design.design_8_02.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 决策结果
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EngineResult {
  /** 执行结果 */
  private boolean isSuccess;

  /** 用户ID */
  private String userId;

  /** 规则树ID */
  private Long treeId;

  /** 果实节点ID */
  private Long nodeId;

  /** 果实节点值 */
  private String nodeValue;

  public EngineResult(String userId, Long treeId, Long nodeId, String nodeValue) {
    this.isSuccess = true;
    this.userId = userId;
    this.treeId = treeId;
    this.nodeId = nodeId;
    this.nodeValue = nodeValue;
  }
}
