package core.fruit;

/**
 * @author zhaoxiaoping
 * @Description: 苹果
 * @Date 2021-3-10
 **/
public class Apple extends AbstractFruit {

  public boolean isSweet() {
    return true;
  }

  @Override
  public boolean isTasty() {
    return isSweet();
  }
}
