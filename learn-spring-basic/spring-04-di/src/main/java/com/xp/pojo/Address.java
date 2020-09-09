package com.xp.pojo;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-9
 **/
public class Address {

  private String address;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Address{" +
        "address='" + address + '\'' +
        '}';
  }
}
