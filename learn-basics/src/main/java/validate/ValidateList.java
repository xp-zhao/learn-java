package validate;

import java.util.List;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2021-11-22
 */
@Data
public class ValidateList<T> {
  private List<T> list;
}
