package permutation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhaoxiaoping
 * @Description: 组合示例
 * @Date 2020-9-23
 **/
public class CombinationExample {

  public static void main(String[] args) {
    ArrayList<String> teams = new ArrayList<String>(Arrays.asList("t1", "t2", "t3"));
    combine(teams, new ArrayList<>(), 2);
  }

  /**
   * 使用递归，找出所有可能的队伍组合
   *
   * @param teams  还有多少队伍没有参数组合
   * @param result 保存当前已经组合的队伍
   * @param m
   */
  public static void combine(ArrayList<String> teams, ArrayList<String> result, int m) {
    // 已经组合了 m 个元素，输出结果
    if (result.size() == m) {
      System.out.println(result);
      return;
    }
    for (int i = 0; i < teams.size(); i++) {
      // 从剩下的队伍中，选择一个 加入结果
      ArrayList<String> newResult = (ArrayList<String>) result.clone();
      newResult.add(teams.get(i));

      // 只考虑当前选择之后的所有队伍
      ArrayList<String> restTeams = new ArrayList<>(teams.subList(i + 1, teams.size()));
      // 递归调用，对剩余的队伍继续生成组合
      combine(restTeams, newResult, m);
    }
  }
}
