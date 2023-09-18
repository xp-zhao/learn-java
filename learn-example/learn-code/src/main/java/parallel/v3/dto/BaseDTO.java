package parallel.v3.dto;

import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
@Data
public class BaseDTO<T extends Object> {
  /** 返回数据标记 */
  private String key;
  /** 返回的实际数据 */
  private T data;

  public BaseDTO(String key, T data) {
    this.key = key;
    this.data = data;
  }
}
