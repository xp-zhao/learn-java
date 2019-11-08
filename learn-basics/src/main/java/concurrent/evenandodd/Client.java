package concurrent.evenandodd;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/08
 **/
public class Client {

  public static void main(String[] args) {
    Printer printer = new Printer();
    Thread t1 = new Thread(new TaskEvenOdd(10, false, printer), "Odd");
    Thread t2 = new Thread(new TaskEvenOdd(10, true, printer), "Even");
    t1.start();
    t2.start();
  }
}