package core.comparision;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * PlayerSorter.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class PlayerSorter {

  public static void main(String[] args) {
    List<Player> players = Arrays.asList(
        Player.builder().ranking(59).name("John").age(20).build(),
        Player.builder().ranking(67).name("Roger").age(22).build(),
        Player.builder().ranking(45).name("Steven").age(24).build()
    );

    System.out.println("Before Sorting : " + players);
    Collections.sort(players);
    System.out.println("After Sorting : " + players);

    Comparator<Player> byAge = Comparator.comparing(Player::getAge);
    Comparator<Player> byRank = Comparator.comparing(Player::getRanking);
  }
}