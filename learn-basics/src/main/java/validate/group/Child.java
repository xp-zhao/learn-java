package validate.group;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhaoxiaoping
 * @date 2022-4-25
 */
@Getter
@Setter
@ToString
public class Child {
  @NotNull private String name;
}
