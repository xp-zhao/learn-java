package validate;

import cn.hutool.core.util.StrUtil;
import javax.validation.constraints.AssertTrue;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2024-5-7
 */
@Data
@ValidPersonFields
public class Person {
  private String name;
  private Integer age;
  private String email;
  private String address;

  @AssertTrue(message = "用户信息非法")
  public boolean isValid() {
    return StrUtil.isNotBlank(name) && age >= 18;
  }
}
