package validate;

import cn.hutool.core.util.StrUtil;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhaoxiaoping
 * @date 2024-5-7
 */
public class PersonFieldsValidator implements ConstraintValidator<ValidPersonFields, Person> {
  @Override
  public boolean isValid(Person value, ConstraintValidatorContext context) {
    // 禁用默认的 message, 否则会输出两次错误信息
    context.disableDefaultConstraintViolation();
    if (StrUtil.isAllBlank(value.getEmail(), value.getAddress())) {
      context
          .buildConstraintViolationWithTemplate("email 和 address 不能同时为空!")
          .addConstraintViolation();
      return false;
    }
    return true;
  }
}
