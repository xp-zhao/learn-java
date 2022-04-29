package validate.group;

import java.lang.reflect.Field;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 枚举值校验器
 *
 * @author zhaoxiaoping
 * @date 2022-4-29
 */
public class EnumValueValidator implements ConstraintValidator<EnumValue, Object> {

  private Class<? extends Enum<?>> enumClass;
  private String enumField;

  @Override
  public void initialize(EnumValue enumValue) {
    enumClass = enumValue.enumClass();
    enumField = enumValue.enumField();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    if (null == value || null == enumClass || null == enumField || "".equals(enumField)) {
      return false;
    }
    try {
      Field field = enumClass.getDeclaredField(enumField);
      Object[] objects = enumClass.getEnumConstants();
      if (null != objects) {
        field.setAccessible(true);
        for (Object object : objects) {
          if (value.equals(field.get(object))) {
            return true;
          }
        }
      }
      return false;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
