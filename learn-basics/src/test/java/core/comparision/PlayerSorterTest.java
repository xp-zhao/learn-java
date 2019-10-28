package core.comparision;

import core.comparision.comparator.PlayerAgeComparator;
import core.comparision.comparator.PlayerRankingComparator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * PlayerSorterTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class PlayerSorterTest {

  private List<Player> players;

  @Before
  public void init() {
    players = Arrays.asList(
        Player.builder().ranking(59).name("John").age(20).build(),
        Player.builder().ranking(67).name("Roger").age(22).build(),
        Player.builder().ranking(45).name("Steven").age(24).build()
    );
  }

  @Test
  public void testSortByRanking() {
    System.out.println("Before Sorting : " + players);
    PlayerRankingComparator comparator = new PlayerRankingComparator();
    Collections.sort(players, comparator);
    System.out.println("After Sorting : " + players);
  }

  @Test
  public void testSortByAge() {
    System.out.println("Before Sorting : " + players);
    PlayerAgeComparator comparator = new PlayerAgeComparator();
    Collections.sort(players, comparator);
    System.out.println("After Sorting : " + players);
  }
}