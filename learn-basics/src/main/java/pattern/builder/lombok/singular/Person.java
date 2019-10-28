package pattern.builder.lombok.singular;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

/**
 * Person.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
@Getter
@Builder
@ToString
public class Person {

  private final String givenName;
  private final String additionalName;
  private final String familyName;
  @Singular("oneTag")
  private final List<String> tags;
}