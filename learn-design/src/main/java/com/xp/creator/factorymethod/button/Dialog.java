package com.xp.creator.factorymethod.button;


/**
 * @author zhaoxiaoping
 * @Description: 对话框基础工厂
 * @Date 2020-10-16
 **/
public abstract class Dialog {

  public void renderDialog() {
    Button button = createButton();
    button.render();
  }

  /**
   * 创建按钮
   *
   * @return
   */
  public abstract Button createButton();
}
