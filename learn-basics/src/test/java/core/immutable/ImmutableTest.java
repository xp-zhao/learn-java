package core.immutable;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * ImmutableTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/24
 **/
public class ImmutableTest {

  @Test
  public void testString() {
    String str1 = "xp";
    String str2 = "xp";
    Assertions.assertThat(str1).isSameAs(str2);

    String str3 = new String("xp");
    Assertions.assertThat(str1).isNotSameAs(str3);

    String str4 = new String("xp");
    Assertions.assertThat(str3).isNotSameAs(str4);
  }

  @Test
  public void testIntern() {
    String str1 = "str";
    String str2 = new String("str");

    Assertions.assertThat(str1).isNotSameAs(str2);

    String str3 = str2.intern();
    Assertions.assertThat(str1).isSameAs(str3);
  }
}