package com.xp.spring.ioc.overview.domain;

import com.xp.spring.ioc.overview.annotation.Supper;

/**
 * @author zhaoxiaoping
 * @Description: 超级用户
 * @Date 2021-3-25
 **/
@Supper
public class SupperUser extends User {

  private String address;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "SupperUser{" +
        "address='" + address + '\'' +
        "} " + super.toString();
  }
}
