package core.fruit;

/**
 * @author zhaoxiaoping
 * @Description: 西瓜
 * @Date 2021-3-10
 **/
public class Watermelon extends AbstractFruit {

  public boolean isJuicy() {
    return true;
  }

  @Override
  public boolean isTasty() {
    return isJuicy();
  }
}
