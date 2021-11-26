package com.xp.creator.factorymethod.button;

/**
 * @author zhaoxiaoping
 * @Description: html 按钮实现
 * @Date 2020-10-16
 **/
public class HtmlButton implements Button {

  @Override
  public void render() {
    System.out.println("<button>Test Button</button>");
    onClick();
  }

  @Override
  public void onClick() {
    System.out.println("Click! Button says - 'Hello World!'");
  }
}
