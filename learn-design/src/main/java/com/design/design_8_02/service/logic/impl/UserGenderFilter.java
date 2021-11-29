package com.design.design_8_02.service.logic.impl;

import com.design.design_8_02.service.logic.BaseLogic;
import java.util.Map;

/**
 * 性别决策
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class UserGenderFilter extends BaseLogic {

  @Override
  public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
    return decisionMatter.get("gender");
  }
}
