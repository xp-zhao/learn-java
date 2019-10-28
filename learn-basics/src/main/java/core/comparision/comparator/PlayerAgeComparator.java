package core.comparision.comparator;

import core.comparision.Player;
import java.util.Comparator;

/**
 * PlayerAgeComparator.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class PlayerAgeComparator implements Comparator<Player> {

  @Override
  public int compare(Player o1, Player o2) {
    return o1.getAge() - o1.getAge();
  }
}