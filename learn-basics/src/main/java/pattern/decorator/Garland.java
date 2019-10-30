package pattern.decorator;

/**
 * Garland.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class Garland extends TreeDecorator {

  public Garland(ChristmasTree tree) {
    super(tree);
  }

  @Override
  public String decorate() {
    return super.decorate() + decorateWithGarland();
  }

  private String decorateWithGarland() {
    return " with Garland";
  }
}