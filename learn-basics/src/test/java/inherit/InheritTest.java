package inherit;


import core.inherit.Actress;
import core.inherit.Person;
import core.inherit.Waitress;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * InheritTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
public class InheritTest {

  @Test
  public void testStarter() {
    Assertions.assertThat(new Waitress()).isInstanceOf(Person.class);
    Assertions.assertThat(new Actress()).isInstanceOf(Person.class);
  }
}