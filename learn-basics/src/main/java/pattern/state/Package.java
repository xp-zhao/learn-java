package pattern.state;

import lombok.Data;

/**
 * Package.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
@Data
public class Package {

  private PackageState state = new OrderState();

  public void previousState() {
    state.prev(this);
  }

  public void nextState() {
    state.next(this);
  }

  public void printState() {
    state.printStatus();
  }
}