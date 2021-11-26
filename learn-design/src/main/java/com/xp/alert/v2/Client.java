package com.xp.alert.v2;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-5-25
 **/
public class Client {

  public static void main(String[] args) {
    ApiStatInfo apiStatInfo = new ApiStatInfo();
    ApplicationContext.getInstance().getAlert().check(apiStatInfo);
  }
}
