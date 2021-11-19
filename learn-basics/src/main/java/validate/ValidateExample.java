package validate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/11/19 10:32 下午 */
public class ValidateExample {
  public static void main(String[] args) {
    User user = new User();
    user.setId(1);
    user.setAddress("xp");
    System.out.println(user);
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<User>> set = validator.validate(user);
    if(!set.isEmpty()){
      System.out.println(set);
    }
  }
}
