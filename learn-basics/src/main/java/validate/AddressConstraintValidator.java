package validate;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/11/19 10:44 下午 */
public class AddressConstraintValidator
    implements ConstraintValidator<Address, ValidateList<Region>> {
  @Override
  public void initialize(Address address) {}

  @Override
  public boolean isValid(
      ValidateList<Region> s, ConstraintValidatorContext constraintValidatorContext) {
    List<Region> list = s.getList();
    return list.contains("xx");
    //    return StrUtil.equals(s.getList(), "xp");
  }
}
