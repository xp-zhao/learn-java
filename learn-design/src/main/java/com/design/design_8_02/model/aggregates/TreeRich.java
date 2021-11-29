package com.design.design_8_02.model.aggregates;

import com.design.design_8_02.model.vo.TreeNode;
import com.design.design_8_02.model.vo.TreeRoot;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 规则树聚合
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeRich {
  /** 树根信息 */
  private TreeRoot treeRoot;

  /** 树节点ID -> 子节点 */
  private Map<Long, TreeNode> treeNodeMap;
}
