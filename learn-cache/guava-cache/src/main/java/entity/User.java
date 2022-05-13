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
public class User {
  private String name;
  private Integer age;
}
