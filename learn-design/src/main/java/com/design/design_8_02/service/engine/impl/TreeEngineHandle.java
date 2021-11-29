package com.design.design_8_02.service.engine.impl;

import com.design.design_8_02.model.aggregates.TreeRich;
import com.design.design_8_02.model.vo.EngineResult;
import com.design.design_8_02.model.vo.TreeNode;
import com.design.design_8_02.service.engine.EngineBase;
import java.util.Map;

/**
 * 决策引擎实现
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class TreeEngineHandle extends EngineBase {

  @Override
  public EngineResult process(
      Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
    // 决策流程
    TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
    // 决策结果
    return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
  }
}
