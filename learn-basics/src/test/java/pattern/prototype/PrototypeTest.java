package pattern.prototype;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * PrototypeTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/24
 **/
public class PrototypeTest {

  @Test
  public void testCreate() {
    Tree tree = new Tree(20, 10);
    tree.setPosition(30);
    Tree anotherTree = tree.clone();
    anotherTree.setPosition(40);

    Assertions.assertThat(30).isEqualTo(tree.getPosition());
    Assertions.assertThat(40).isEqualTo(anotherTree.getPosition());
  }
}