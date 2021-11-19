package validate;

import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/11/19 10:44 下午 */
public class AddressConstraintValidator implements ConstraintValidator<Address, String> {
  @Override
  public void initialize(Address address) {}

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    return StrUtil.equals(s, "xp");
  }
}
