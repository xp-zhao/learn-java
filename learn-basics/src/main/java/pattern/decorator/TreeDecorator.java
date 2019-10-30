package pattern.decorator;

/**
 * TreeDecorator.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public abstract class TreeDecorator implements ChristmasTree {

  private ChristmasTree tree;

  public TreeDecorator(ChristmasTree tree) {
    this.tree = tree;
  }

  @Override
  public String decorate() {
    return tree.decorate();
  }
}