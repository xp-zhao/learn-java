package core.comparision.comparator;

import core.comparision.Player;
import java.util.Comparator;

/**
 * PlayerRankingComparator.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class PlayerRankingComparator implements Comparator<Player> {

  @Override
  public int compare(Player o1, Player o2) {
    return o1.getRanking() - o2.getRanking();
  }
}