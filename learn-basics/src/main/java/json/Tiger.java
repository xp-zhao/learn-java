package json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * @author zhaoxiaoping
 * @Description: 老虎
 * @Date 2020/5/6
 **/
@Data
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Tiger extends Animal {

  private String tigerFeature;

  @Override
  public String getName() {
    return "tiger";
  }
}
