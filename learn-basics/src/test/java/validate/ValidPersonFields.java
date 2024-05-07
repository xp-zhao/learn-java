package validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author zhaoxiaoping
 * @date 2024-5-7
 */
@Constraint(validatedBy = PersonFieldsValidator.class)
@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPersonFields {
  String message() default "Person fields are not valid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
