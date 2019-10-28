package pattern.mediator;

import lombok.Data;

/**
 * Button.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
@Data
public class Button {

  private Mediator mediator;

  public void press(){
    mediator.press();
  }
}