package pattern.builder.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Child.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/25
 **/
@Getter
@ToString
public class Child extends Parent {

  private final String childName;
  private final int childAge;

  @Builder
  public Child(String parentName, int parentAge, String childName, int childAge) {
    super(parentName, parentAge);
    this.childName = childName;
    this.childAge = childAge;
  }

}