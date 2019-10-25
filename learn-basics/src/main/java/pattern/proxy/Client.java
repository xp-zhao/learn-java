package pattern.proxy;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/25
 **/
public class Client {

  public static void main(String[] args) {
    ExpensiveObject object = new ExpensiveObjectProxy();
    object.process();
    object.process();
  }
}