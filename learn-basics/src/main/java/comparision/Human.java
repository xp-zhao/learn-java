package comparision;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Human.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {

  private String name;
  private int age;

  public static int compareByNameThenAge(Human h1, Human h2) {
    if (h1.name.equals(h2.name)) {
      return h1.age - h2.age;
    } else {
      return h1.name.compareTo(h2.name);
    }
  }
}