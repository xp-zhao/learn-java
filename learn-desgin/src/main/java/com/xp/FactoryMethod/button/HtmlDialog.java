package com.xp.FactoryMethod.button;


/**
 * @author zhaoxiaoping
 * @Description: Html 对话框创建工厂
 * @Date 2020-10-16
 **/
public class HtmlDialog extends Dialog {

  @Override
  public Button createButton() {
    return new HtmlButton();
  }
}
