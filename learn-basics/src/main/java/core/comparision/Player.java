package core.comparision;

import lombok.Builder;
import lombok.Data;

/**
 * Player.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
@Data
@Builder
public class Player implements Comparable<Player> {

  private int ranking;
  private String name;
  private int age;

  @Override
  public int compareTo(Player player) {
    return this.ranking - player.getRanking();
  }
}