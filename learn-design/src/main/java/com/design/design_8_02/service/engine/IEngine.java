package com.design.design_8_02.service.engine;

import com.design.design_8_02.model.aggregates.TreeRich;
import com.design.design_8_02.model.vo.EngineResult;
import java.util.Map;

/**
 * 决策引擎接口
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public interface IEngine {
  /**
   * 决策执行
   *
   * @param treeId 树id
   * @param userId 用户id
   * @param treeRich 规则树聚合
   * @param decisionMatter
   * @return {@code EngineResult}
   */
  EngineResult process(
      final Long treeId,
      final String userId,
      TreeRich treeRich,
      final Map<String, String> decisionMatter);
}
