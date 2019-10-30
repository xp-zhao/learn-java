package pattern.state;

/**
 * OrderState.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class OrderState implements PackageState {

  @Override
  public void next(Package pck) {
    pck.setState(new DeliveredState());
  }

  @Override
  public void prev(Package pck) {
    System.out.println("The package is in its root state.");
  }

  @Override
  public void printStatus() {
    System.out.println("Package ordered, not delivered to the office yet.");
  }
}