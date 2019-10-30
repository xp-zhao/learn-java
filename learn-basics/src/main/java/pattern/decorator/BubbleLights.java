package pattern.decorator;

/**
 * BubbleLights.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class BubbleLights extends TreeDecorator {

  public BubbleLights(ChristmasTree tree) {
    super(tree);
  }

  @Override
  public String decorate() {
    return super.decorate() + decorateWithBubbleLights();
  }

  private String decorateWithBubbleLights() {
    return " with Bubble Lights";
  }
}