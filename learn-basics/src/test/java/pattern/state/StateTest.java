package pattern.state;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * StateTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class StateTest {

  @Test
  public void testState() {
    Package pck = new Package();

    Assertions.assertThat(pck.getState()).isInstanceOf(OrderState.class);
    pck.nextState();

    Assertions.assertThat(pck.getState()).isInstanceOf(DeliveredState.class);
    pck.nextState();

    Assertions.assertThat(pck.getState()).isInstanceOf(ReceivedState.class);
  }

  @Test
  public void testPrevious() {
    Package pck = new Package();
    pck.setState(new DeliveredState());
    pck.previousState();

    Assertions.assertThat(pck.getState()).isInstanceOf(OrderState.class);
  }
}