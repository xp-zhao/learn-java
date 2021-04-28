package com.xp.executor.v1;

/**
 * @author zhaoxiaoping
 * @Description: 国籍规则校验
 * @Date 2021-4-25
 **/
public class NationalityRule extends AbstractRule {

  @Override
  protected <T> T convert(RuleDto dto) {
    NationalityRuleDto nationalityRuleDto = new NationalityRuleDto();
    if (dto.getAddress().startsWith(RuleConstant.MATCH_ADDRESS_START)) {
      nationalityRuleDto.setNationality(RuleConstant.MATCH_NATIONALITY_START);
    }
    return (T) nationalityRuleDto;
  }


  @Override
  protected <T> boolean executeRule(T t) {
    System.out.println("NationalityRule invoke!");
    NationalityRuleDto nationalityRuleDto = (NationalityRuleDto) t;
    if (nationalityRuleDto.getNationality().startsWith(RuleConstant.MATCH_NATIONALITY_START)) {
      return true;
    }
    return false;
  }
}
