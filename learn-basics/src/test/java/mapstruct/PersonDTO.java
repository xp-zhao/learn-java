package mapstruct;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: DTO 对象
 * @Date 2020-8-12
 **/
@Data
public class PersonDTO {

  private String userName;

  private Integer age;

  private LocalDateTime birthday;

  private Gender gender;
}
