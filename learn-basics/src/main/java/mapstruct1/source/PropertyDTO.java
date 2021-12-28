package mapstruct1.source;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2021-12-28
 */
@Data
@AllArgsConstructor
public class PropertyDTO {
  private String name;
  private List<ValueDTO> value;
  private String code;
}
