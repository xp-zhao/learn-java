package pattern.proxy;

/**
 * ExpensiveObjectProxy.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/25
 **/
public class ExpensiveObjectProxy implements ExpensiveObject {

  private static ExpensiveObject object;

  @Override
  public void process() {
    if (object == null) {
      object = new ExpensiveObjectImpl();
    }
    object.process();
  }
}