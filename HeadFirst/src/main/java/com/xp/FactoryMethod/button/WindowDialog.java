package com.xp.FactoryMethod.button;

/**
 * @author zhaoxiaoping
 * @Description: window弹窗创建工厂
 * @Date 2020-10-16
 **/
public class WindowDialog extends Dialog {

  @Override
  public Button createButton() {
    return new WindowButton();
  }
}
