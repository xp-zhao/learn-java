package com.design.design_8_02.service.engine;

import com.design.design_8_02.service.logic.LogicFilter;
import com.design.design_8_02.service.logic.impl.UserAgeFilter;
import com.design.design_8_02.service.logic.impl.UserGenderFilter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 决策节点配置
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class EngineConfig {
  static Map<String, LogicFilter> logicFilterMap;

  static {
    logicFilterMap = new ConcurrentHashMap<>();
    logicFilterMap.put("userAge", new UserAgeFilter());
    logicFilterMap.put("userGender", new UserGenderFilter());
  }

  public Map<String, LogicFilter> getLogicFilterMap() {
    return logicFilterMap;
  }

  public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
    EngineConfig.logicFilterMap = logicFilterMap;
  }
}
