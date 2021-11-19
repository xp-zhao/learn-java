package validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** @Author: xp-zhao @Description: 地址约束 @DateTime: 2021/11/19 10:41 下午 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AddressConstraintValidator.class)
public @interface Address {
  String message() default "地址有误";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
