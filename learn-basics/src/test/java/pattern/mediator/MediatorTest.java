package pattern.mediator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * MediatorTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class MediatorTest {

  private Mediator mediator;
  private Button button;
  private Fan fan;
  private PowerSupplier powerSupplier;

  @Before
  public void init() {
    mediator = new Mediator();
    button = new Button();
    fan = new Fan();
    powerSupplier = new PowerSupplier();
    mediator.setButton(button);
    mediator.setFan(fan);
    mediator.setPowerSupplier(powerSupplier);
    button.setMediator(mediator);
    fan.setMediator(mediator);
  }

  @Test
  public void testTurnOnAndOff() {

    Assert.assertFalse(fan.isOn());

    button.press();
    Assert.assertTrue(fan.isOn());

    button.press();
    Assert.assertFalse(fan.isOn());
  }
}