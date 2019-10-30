package pattern.state;

/**
 * ReceivedState.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class ReceivedState implements PackageState {

  @Override
  public void next(Package pck) {
    System.out.println("This package is already received by a client.");
  }

  @Override
  public void prev(Package pck) {
    pck.setState(new DeliveredState());
  }

  @Override
  public void printStatus() {
    System.out.println("Package was received by client.");
  }
}