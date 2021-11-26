package com.xp.executor;

import java.util.Collections;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @Description: 原始需求
 * @Date 2021-4-25
 **/
public class OriginExample {

  public static void main(String[] args) {
    System.out.println(verify(Collections.EMPTY_LIST));
  }

  public static boolean verify(List<Boolean> rules) {
    if (rules.get(0)) {
      return false;
    }
    if (rules.get(1)) {
      return false;
    }
    if (rules.get(2) && rules.get(3)) {
      return false;
    }
    if (rules.get(4) || rules.get(5) || rules.get(6)) {
      return false;
    }
    return true;
  }
}
