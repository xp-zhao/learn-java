package com.xp.dynamic;

/**
 * @author zhaoxiaoping
 * @Description: 房东
 * @Date 2020-9-15
 **/
public class Host implements Rent {

  public String rent(String address) {
    System.out.println("房东出租房子: " + address);
    return "success";
  }
}
