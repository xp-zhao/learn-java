package pattern.adapter;

/**
 * MovableAdapterImpl.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/29
 **/
public class MovableAdapterImpl implements MovableAdapter {

  private Movable luxuryCars;

  public MovableAdapterImpl(Movable movable) {
    this.luxuryCars = movable;
  }

  @Override
  public double getSpeed() {
    return convertMPHtoKMPH(luxuryCars.getSpeed());
  }

  private double convertMPHtoKMPH(double mph) {
    return mph * 1.60934;
  }
}