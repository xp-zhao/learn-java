package mapstruct1.target1;

import java.util.List;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2021-12-28
 */
@Data
public class TargetDTO {
  private String id;
  private List<ContentItem> content;
  private List<PropertyItem> property;
  private List<TargetDTO> childList;
}
