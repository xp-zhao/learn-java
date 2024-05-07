package validate;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2024-5-7
 */
@Slf4j
public class ValidateTest {

  @Test
  public void testAssertTrue() {
    Person person = new Person();
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<Person>> validateResult = validator.validate(person);
    validateResult.forEach(item -> logPrint(item));
    //    person.setName("xxx");
    //    person.setAge(20);
    //    validator.validate(person).forEach(item -> logPrint(item));
  }

  private void logPrint(ConstraintViolation obj) {
    log.info("value: {}", obj.getInvalidValue());
    log.info("message: {}", obj.getMessage());
  }
}
