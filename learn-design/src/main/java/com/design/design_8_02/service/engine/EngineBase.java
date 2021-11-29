package com.design.design_8_02.service.engine;

import com.design.design_8_02.model.aggregates.TreeRich;
import com.design.design_8_02.model.vo.EngineResult;
import com.design.design_8_02.model.vo.TreeNode;
import com.design.design_8_02.model.vo.TreeRoot;
import com.design.design_8_02.service.logic.LogicFilter;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * 基础决策引擎
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Slf4j
public abstract class EngineBase extends EngineConfig implements IEngine {

  @Override
  public abstract EngineResult process(
      Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);

  protected TreeNode engineDecisionMaker(
      TreeRich treeRich, Long treeId, String userId, Map<String, String> decisionMatter) {
    TreeRoot treeRoot = treeRich.getTreeRoot();
    Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
    // 规则树根ID
    Long rootNodeId = treeRoot.getTreeRootNodeId();
    TreeNode treeNodeInfo = treeNodeMap.get(rootNodeId);
    // 节点类型[NodeType]；1子叶、2果实
    while (treeNodeInfo.getNodeType().equals(1)) {
      String ruleKey = treeNodeInfo.getRuleKey();
      LogicFilter logicFilter = logicFilterMap.get(ruleKey);
      String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
      Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLinkList());
      treeNodeInfo = treeNodeMap.get(nextNode);
      log.info(
          "决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}",
          treeRoot.getTreeName(),
          userId,
          treeId,
          treeNodeInfo.getTreeNodeId(),
          ruleKey,
          matterValue);
    }
    return treeNodeInfo;
  }
}
