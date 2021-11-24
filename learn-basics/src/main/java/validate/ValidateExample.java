package validate;

import cn.hutool.core.util.ReUtil;
import java.util.Arrays;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/11/19 10:32 下午 */
public class ValidateExample {
  public static void main(String[] args) {
    String TIME_PATTERN = "^[1-9][0-9]{0,2}$";
    System.out.println(ReUtil.isMatch(TIME_PATTERN, "999"));
    User user = new User();
    user.setId(1);
    user.setTime("1");
    ValidateList list = new ValidateList();
    list.setList(Arrays.asList("xx1"));
    user.setAddress(list);
    user.setIdx(1);
    System.out.println(user);
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<User>> set = validator.validate(user);
    set.forEach(
        item -> {
          System.out.println(item.getInvalidValue());
          System.out.println(item.getMessage());
        });
  }
}
