package validate;

import lombok.Data;

import javax.validation.constraints.NotNull;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/11/19 10:30 下午 */
@Data
public class User {
  @NotNull(message = "id 不能为空")
  private Integer id;

  @NotNull(message = "name 不能为空")
  private String name;

  @Address
  private String address;
}
