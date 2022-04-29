package validate.group;

/**
 * 枚举值校验
 *
 * @author zhaoxiaoping
 * @date 2022-4-29
 */
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {EnumValueValidator.class})
public @interface EnumValue {
  String message() default "入参不在枚举范围内";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  /** 目标枚举类 */
  Class<? extends Enum<?>> enumClass();

  /** 目标枚举属性 */
  String enumField();
}
