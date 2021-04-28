package com.xp.executor.v1;

/**
 * @author zhaoxiaoping
 * @Description: 地址规则校验
 * @Date 2021-4-25
 **/
public class AddressRule extends AbstractRule {

  @Override
  public boolean execute(RuleDto dto) {
    System.out.println("AddressRule invoke!");
    return dto.getAddress().equals(RuleConstant.MATCH_ADDRESS_START);
  }
}
