package com.xp.math;

import cn.hutool.core.util.ObjectUtil;
import java.util.Arrays;
import java.util.List;

/**
 * @description: lambda表达式计算和
 * @author: zhaoxp
 * @create: 2019/05/22
 **/
public class LambdaSum {

  public static void main(String[] args) {
    List<Score> scores = Arrays.asList(new Score("xp", null), new Score("ch", 0));
    int sum = scores.stream()
        .filter(score -> ObjectUtil.isNotEmpty(score.getScore()))
        .mapToInt(Score::getScore)
        .sum();
    System.out.println(sum);
  }

  public static class Score {

    private String name;
    private Integer score;

    public Score(String name, Integer score) {
      this.name = name;
      this.score = score;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getScore() {
      return score;
    }

    public void setScore(int score) {
      this.score = score;
    }
  }
}