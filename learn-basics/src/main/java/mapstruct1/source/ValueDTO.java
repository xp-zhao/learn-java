package mapstruct1.source;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2021-12-28
 */
@Data
@AllArgsConstructor
public class ValueDTO {
  private String id;
  private String name;
  private String sort;
  private String code;
}
