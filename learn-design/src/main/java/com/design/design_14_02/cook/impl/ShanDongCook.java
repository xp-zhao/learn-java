package com.design.design_14_02.cook.impl;

import com.design.design_14_02.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * 山东厨师
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Slf4j
public class ShanDongCook implements ICook {

  @Override
  public void doCooking() {
    log.info("山东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头");
  }
}
