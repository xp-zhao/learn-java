package pattern.state;

/**
 * DeliveredState.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class DeliveredState implements PackageState {

  @Override
  public void next(Package pck) {
    pck.setState(new ReceivedState());
  }

  @Override
  public void prev(Package pck) {
    pck.setState(new OrderState());
  }

  @Override
  public void printStatus() {
    System.out.println("Package delivered to post office, not received yet.");
  }
}