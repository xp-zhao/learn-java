package com.design.design_14_02.cook.impl;

import com.design.design_14_02.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * 江苏厨师
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Slf4j
public class JiangSuCook implements ICook {

  @Override
  public void doCooking() {
    log.info("江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系。");
  }
}
