package mapstruct1;

import java.time.LocalDateTime;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-8-12
 **/
public class Demo {

  public static void main(String[] args) {
    PersonDO personDO = new PersonDO();

    personDO.setName("xxx");

    personDO.setAge(26);

    personDO.setBirthday(LocalDateTime.now());

    personDO.setId(1);

    personDO.setGender(Gender.MALE.name());

    PersonDTO personDTO = PersonConverter.INSTANCE.do2dto(personDO);

    System.out.println(personDTO);
  }
}
