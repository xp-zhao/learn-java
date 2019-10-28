package list;

import lombok.Builder;
import lombok.Data;

/**
 * Employee.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
@Builder
@Data
public class Employee {

  long id;
  String name;
}