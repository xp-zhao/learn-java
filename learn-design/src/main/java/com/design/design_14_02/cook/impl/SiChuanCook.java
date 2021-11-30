package com.design.design_14_02.cook.impl;

import com.design.design_14_02.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * 四川厨师
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Slf4j
public class SiChuanCook implements ICook {

  @Override
  public void doCooking() {
    log.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系。");
  }
}
