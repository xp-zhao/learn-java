package com.design.design_14_02.cuisine.impl;

import com.design.design_14_02.cook.ICook;
import com.design.design_14_02.cuisine.ICuisine;

/**
 * 四川菜
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class SiChuanCuisine implements ICuisine {

  private ICook cook;

  public SiChuanCuisine(ICook cook) {
    this.cook = cook;
  }

  @Override
  public void cook() {
    cook.doCooking();
  }
}
