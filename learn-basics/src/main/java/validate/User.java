package validate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/11/19 10:30 下午 */
@Data
public class User {
  @NotNull(message = "id 不能为空")
  private Integer id;

  @NotNull(message = "name 不能为空")
  private String name;

  @Pattern(regexp = "^[1-9]+[0-9]*$", message = "时间只能是正整数")
  private String time;
  
  private Number idx;
  
  @Address
  private ValidateList<Region> address;
}
