package core.fruit;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaoxiaoping
 * @Description: 挑选水果
 * @Date 2021-3-10
 **/
public class FruitPicker {

  public List<AbstractFruit> pickGood(List<AbstractFruit> fruits) {
//    return fruits.stream().filter(this::check).collect(Collectors.toList());
    // 提升抽象层次
    return fruits.stream().filter(AbstractFruit::isTasty).collect(Collectors.toList());
  }

  public boolean check(AbstractFruit fruit) {
    if (fruit instanceof Apple) {
      return ((Apple) fruit).isSweet();
    }
    if (fruit instanceof Watermelon) {
      return ((Watermelon) fruit).isJuicy();
    }
    return false;
  }
}
