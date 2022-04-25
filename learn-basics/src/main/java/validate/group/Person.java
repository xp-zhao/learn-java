package validate.group;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.group.GroupSequenceProvider;

/**
 * @author zhaoxiaoping
 * @date 2022-4-25
 */
@GroupSequenceProvider(PersonGroupSequenceProvider.class)
@Getter
@Setter
@ToString
public class Person {
  @NotBlank(message = "name 不能为空")
  private String name;

  @NotNull
  @Range(min = 10, max = 40)
  private Integer age;

  @NotNull(groups = {WhenAge20And30Group.class, WhenAge30And40Group.class})
  @Size(min = 1, max = 2, groups = WhenAge20And30Group.class)
  @Size(min = 3, max = 5, groups = WhenAge30And40Group.class)
  private List<String> hobbies;
  // 级联校验
  @Valid @NotNull private Child child;
  /** 定义专属的业务逻辑分组 */
  public interface WhenAge20And30Group {}

  public interface WhenAge30And40Group {}
}
