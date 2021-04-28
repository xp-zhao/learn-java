package com.xp.executor.v1;

/**
 * @author zhaoxiaoping
 * @Description: 规则接口
 * @Date 2021-4-25
 **/
public interface BaseRule {

  /**
   * 规则校验
   *
   * @param data 业务数据
   * @return 校验结果
   */
  boolean execute(RuleDto data);
}
