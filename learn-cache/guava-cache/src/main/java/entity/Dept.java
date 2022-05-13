package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoxiaoping
 * @date 2022-5-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
  private String name;
  private Integer count;
}
