package pattern.decorator;

/**
 * ChristmasTreeImpl.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class ChristmasTreeImpl implements ChristmasTree {

  @Override
  public String decorate() {
    return "Christmas Tree";
  }
}