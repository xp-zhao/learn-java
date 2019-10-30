package pattern.state;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class Client {

  public static void main(String[] args) {
    Package pck = new Package();
    pck.printState();

    pck.nextState();
    pck.printState();

    pck.nextState();
    pck.printState();

    pck.nextState();
    pck.printState();
  }
}