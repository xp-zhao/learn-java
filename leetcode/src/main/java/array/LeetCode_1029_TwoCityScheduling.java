package array;

import java.util.Arrays;

/**
 * @description: 1029.两地调度
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 *
 * 示例： 输入：[[10,20],[30,200],[400,50],[30,20]] 输出：110
 *
 * 解释： 第一个人去 A 市，费用为 10。 第二个人去 A 市，费用为 30。 第三个人去 B 市，费用为 50。 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 * @author: zhaoxp
 * @create: 2019/05/09
 **/
public class LeetCode_1029_TwoCityScheduling {

  public static void main(String[] args) {
    int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
    System.out.println(twoCitySchedCost(costs));
    System.out.println(twoCitySchedCost1(costs));
  }

  public static int twoCitySchedCost(int[][] costs) {
    // 计算每个人到 A/B 两个地方的费用差
    Arrays.sort(costs, (a, b) -> {
      return (a[0] - a[1]) - (b[0] - b[1]);
    });
    int sum = 0;
    for (int i = 0; i < costs.length; i++) {
      if (i < costs.length / 2) {
        sum += costs[i][0];
      } else {
        sum += costs[i][1];
      }
    }
    return sum;
  }

  public static int twoCitySchedCost1(int[][] costs) {
    int sum = 0;
    int[] diff = new int[costs.length];
    // 假设所有人都去了 A ，计算所有费用，和去 A、B 两地的费用差
    for (int i = 0; i < costs.length; i++) {
      sum += costs[i][0]; // 都去 A 底的费用
      diff[i] = costs[i][0] - costs[i][1]; // 去 A、B 两地的费用差
    }
    // 排序
    Arrays.sort(diff);
    // 费用差最大的 N 个人去 B
    for (int i = costs.length - 1; i >= costs.length / 2; i--) {
      sum -= diff[i];
    }
    return sum;
  }

}