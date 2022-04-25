package validate.group;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

/**
 * @author zhaoxiaoping
 * @date 2022-4-25
 */
public class PersonGroupSequenceProvider implements DefaultGroupSequenceProvider<Person> {

  @Override
  public List<Class<?>> getValidationGroups(Person person) {
    List<Class<?>> defaultGroupSequence = new ArrayList<>();
    defaultGroupSequence.add(Person.class);
    if (person != null) {
      Integer age = person.getAge();
      System.err.println("年龄为：" + age + "，执行对应校验逻辑");
      if (age >= 20 && age < 30) {
        defaultGroupSequence.add(Person.WhenAge20And30Group.class);
      } else if (age >= 30 && age < 40) {
        defaultGroupSequence.add(Person.WhenAge30And40Group.class);
      }
    }
    return defaultGroupSequence;
  }
}
