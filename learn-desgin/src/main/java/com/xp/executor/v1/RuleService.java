package com.xp.executor.v1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author zhaoxiaoping
 * @Description: 执行器
 * @Date 2021-4-25
 **/
public class RuleService {

  private Map<Integer, List<BaseRule>> ruleMap = new HashMap<>();
  private static final int AND = 1;
  private static final int OR = 0;

  public static RuleService create() {
    return new RuleService();
  }

  public RuleService and(List<BaseRule> ruleList) {
    ruleMap.put(AND, ruleList);
    return this;
  }

  public RuleService or(List<BaseRule> ruleList) {
    ruleMap.put(OR, ruleList);
    return this;
  }

  public boolean execute(RuleDto dto) {
    for (Entry<Integer, List<BaseRule>> item : ruleMap.entrySet()) {
      List<BaseRule> rules = item.getValue();
      switch (item.getKey()) {
        case AND:
          System.out.println("and 关系, 串行执行");
          if (!and(dto, rules)) {
            return false;
          }
          break;
        case OR:
          System.out.println("or 关系, 并行执行");
          if (!or(dto, rules)) {
            return false;
          }
          break;
        default:
          break;
      }
    }
    return true;
  }

  private boolean and(RuleDto dto, List<BaseRule> ruleList) {
    for (BaseRule rule : ruleList) {
      boolean execute = rule.execute(dto);
      if (!execute) {
        // 有一个规则失败, 返回 false
        return false;
      }
    }
    // 全部规则校验成功, 返回 true
    return true;
  }

  private boolean or(RuleDto dto, List<BaseRule> ruleList) {
    for (BaseRule rule : ruleList) {
      boolean execute = rule.execute(dto);
      if (execute) {
        // 有一个规则校验通过, 返回 true
        return true;
      }
    }
    // 全部规则校验不通过, 返回 false
    return false;
  }
}
