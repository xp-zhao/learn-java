package pattern.builder.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Parent.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/25
 **/
@Getter
@AllArgsConstructor
public class Parent {

  private final String parentName;
  private final int parentAge;
}