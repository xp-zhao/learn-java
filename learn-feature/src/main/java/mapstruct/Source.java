package mapstruct;

import lombok.Builder;
import lombok.Data;

/**
 * 来源类
 *
 * @author zhaoxiaoping
 * @date 2022-10-26
 */
@Data
@Builder
public class Source {
  private Long id;
  private Long age;
  private String userNick;
}
