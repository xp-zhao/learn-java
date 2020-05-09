package json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * @author zhaoxiaoping
 * @Description: 狮子
 * @Date 2020/5/6
 **/
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Lion extends Animal {

  private String lionFeature;

  @Override
  public String getName(){
    return "lion";
  }
}
