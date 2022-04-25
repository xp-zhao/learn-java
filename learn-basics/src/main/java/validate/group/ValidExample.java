package validate.group;

import java.util.Arrays;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;

/**
 * @author zhaoxiaoping
 * @date 2022-4-25
 */
public class ValidExample {
  public static void main(String[] args) {
    Person person = new Person();
    person.setName("xxx");
    person.setAge(35);
    person.setHobbies(Arrays.asList("足球", "篮球"));
    person.setChild(new Child());
//    Set<ConstraintViolation<Person>> result =
//        Validation.buildDefaultValidatorFactory().getValidator().validate(person);
    ValidatorFactory factory =
        Validation.byProvider(HibernateValidator.class)
            .configure()
            .failFast(true)
            .buildValidatorFactory();
    Set<ConstraintViolation<Person>> result = factory.getValidator().validate(person);
    result.stream()
        .map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue())
        .forEach(System.out::println);
  }
}
