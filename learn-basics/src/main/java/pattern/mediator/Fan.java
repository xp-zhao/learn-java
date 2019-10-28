package pattern.mediator;

import lombok.Data;

/**
 * Fan.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
@Data
public class Fan {

  private Mediator mediator;
  private boolean isOn = false;

  public void turnOn() {
    mediator.start();
    isOn = true;
  }

  public void turnOff() {
    isOn = false;
    mediator.stop();
  }
}