package mapstruct1.target1;

import java.util.List;
import lombok.Data;

/**
 * 复杂 vo 对象
 *
 * @author zhaoxiaoping
 * @date 2022-8-8
 */
@Data
public class ComplexVO {
  private String id;
  private String name;
  private List<AddressVO> addressList;

  @Data
  public static class AddressVO {
    private String id;
    private String name;
  }
}
