package com.xp.executor.v1;

/**
 * @author zhaoxiaoping
 * @Description: 抽象规则模板
 * @Date 2021-4-25
 **/
public abstract class AbstractRule implements BaseRule {

  protected <T> T convert(RuleDto dto) {
    return (T) dto;
  }

  @Override
  public boolean execute(RuleDto dto) {
    return executeRule(convert(dto));
  }

  protected <T> boolean executeRule(T t) {
    return true;
  }
}
