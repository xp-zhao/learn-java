package streamex;

import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2022-8-15
 */
@Data
public class User {

  private int id;
  private String name;
  private Role role = new Role();

  public static class Role {}
}
