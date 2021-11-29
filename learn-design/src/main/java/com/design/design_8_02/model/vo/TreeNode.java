package com.design.design_8_02.model.vo;

import java.util.List;
import lombok.Data;

/**
 * 规则树节点信息
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Data
public class TreeNode {
  /** 规则树ID */
  private Long treeId;

  /** 规则树节点ID */
  private Long treeNodeId;

  /** 节点类型；1子叶、2果实 */
  private Integer nodeType;

  /** 节点值[nodeType=2]；果实值 */
  private String nodeValue;

  /** 规则Key */
  private String ruleKey;

  /** 规则描述 */
  private String ruleDesc;

  /** 节点链路 */
  private List<TreeNodeLink> treeNodeLinkList;
}
