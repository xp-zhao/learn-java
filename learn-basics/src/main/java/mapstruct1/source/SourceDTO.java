package mapstruct1.source;

import java.util.List;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2021-12-28
 */
@Data
public class SourceDTO {
  private String id;
  private List<KeyValueDTO> content;
  private List<PropertyDTO> property;
  private List<SourceDTO> childList;
}
