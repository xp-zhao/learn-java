package com.design.design_14_02;

import com.design.design_14_02.cuisine.ICuisine;
import java.util.ArrayList;
import java.util.List;

/**
 * 饭店小二, 负责下单
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class XiaoEr {
  /** 菜单 */
  private List<ICuisine> cuisineList = new ArrayList<>();

  public void order(ICuisine cuisine) {
    cuisineList.add(cuisine);
  }

  public synchronized void placeOrder() {
    for (ICuisine cuisine : cuisineList) {
      cuisine.cook();
    }
    cuisineList.clear();
  }
}
