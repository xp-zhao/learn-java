package mapstruct1.source;

import java.util.List;
import lombok.Data;

/**
 * 复杂对象DTO
 *
 * @author zhaoxiaoping
 * @date 2022-8-8
 */
@Data
public class ComplexDTO {
  private String id;
  private String name;
  private List<AddressDTO> addressList;

  @Data
  public static class AddressDTO {
    private String key;
    private String value;
  }
}
