package com.design.design_8_02.service.logic;

import com.design.design_8_02.model.vo.TreeNodeLink;
import java.util.List;
import java.util.Map;

/**
 * 决策抽象类
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public abstract class BaseLogic implements LogicFilter {

  @Override
  public Long filter(String matterValue, List<TreeNodeLink> treeNodeLineInfoList) {
    for (TreeNodeLink nodeLine : treeNodeLineInfoList) {
      if (decisionLogic(matterValue, nodeLine)) {
        return nodeLine.getNodeIdTo();
      }
    }
    return 0L;
  }

  @Override
  public abstract String matterValue(
      Long treeId, String userId, Map<String, String> decisionMatter);

  private boolean decisionLogic(String matterValue, TreeNodeLink nodeLink) {
    switch (nodeLink.getRuleLimitType()) {
      case 1:
        return matterValue.equals(nodeLink.getRuleLimitValue());
      case 2:
        return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
      case 3:
        return Double.parseDouble(matterValue) < Double.parseDouble(nodeLink.getRuleLimitValue());
      case 4:
        return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLink.getRuleLimitValue());
      case 5:
        return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLink.getRuleLimitValue());
      default:
        return false;
    }
  }
}
