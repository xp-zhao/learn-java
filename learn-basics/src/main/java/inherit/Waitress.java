package inherit;

import lombok.NoArgsConstructor;

/**
 * Waitress.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
@NoArgsConstructor
public class Waitress extends Person {

  public String serveStarter(String starter) {
    return "Serving a " + starter;
  }
}