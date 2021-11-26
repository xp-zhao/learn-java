package com.xp.executor.v1;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author zhaoxiaoping
 * @Description: 国籍规则业务对象
 * @Date 2021-4-25
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class NationalityRuleDto extends RuleDto {

  private String nationality;
}
