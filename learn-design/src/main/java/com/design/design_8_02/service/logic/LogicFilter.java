package com.design.design_8_02.service.logic;

import com.design.design_8_02.model.vo.TreeNodeLink;
import java.util.List;
import java.util.Map;

/**
 * 逻辑过滤器接口
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public interface LogicFilter {
  /**
   * 逻辑决策器
   *
   * @param matterValue 决策值
   * @param treeNodeLineInfoList 决策节点
   * @return 下一个节点Id
   */
  Long filter(String matterValue, List<TreeNodeLink> treeNodeLineInfoList);

  /**
   * 获取决策值
   *
   * @param treeId 树id
   * @param userId 用户id
   * @param decisionMatter 决策物料
   * @return 决策值
   */
  String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);
}
