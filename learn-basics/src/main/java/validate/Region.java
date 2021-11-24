package validate;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 区域信息
 *
 * @author zhaoxiaoping
 * @date 2021-11-22
 */
@Data
public class Region {
  private String id;
  private String name;
}
