package mapstruct1;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: DO 对象
 * @Date 2020-8-12
 **/
@Data
public class PersonDO {

  private Integer id;

  private String name;

  private int age;

  private LocalDateTime birthday;

  private String gender;
}
