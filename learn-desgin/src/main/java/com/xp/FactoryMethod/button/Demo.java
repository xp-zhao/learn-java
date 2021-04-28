package com.xp.FactoryMethod.button;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-10-16
 **/
public class Demo {

  public static void main(String[] args) {
    Dialog dialog;
    System.out.println(System.getProperty("os.name"));
    if (System.getProperty("os.name").equals("Windows 7")) {
      dialog = new WindowDialog();
    } else {
      dialog = new HtmlDialog();
    }
    dialog.renderDialog();
  }
}
