package mapstruct1.target1;

import java.util.List;
import lombok.Data;
import mapstruct1.source.ValueDTO;

/**
 * @author zhaoxiaoping
 * @date 2021-12-28
 */
@Data
public class PropertyItem {
  private String key;
  private List<ValueDTO> value;
}
