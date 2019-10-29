package pattern.adapter;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/29
 **/
public class Client {

  public static void main(String[] args) {
    Movable bugattiVeyron = new BugattiVeyron();
    MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);

    System.out.println(bugattiVeyron.getSpeed());
    System.out.println(bugattiVeyronAdapter.getSpeed());
  }
}