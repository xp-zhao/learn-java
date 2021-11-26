package com.xp.creator.factorymethod.button;

/**
 * @author zhaoxiaoping
 * @Description: 按钮接口
 * @Date 2020-10-16
 **/
public interface Button {

  /**
   * 渲染
   */
  void render();

  /**
   * 点击事件
   */
  void onClick();
}
