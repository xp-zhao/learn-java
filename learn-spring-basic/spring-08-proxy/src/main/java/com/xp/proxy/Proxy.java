package com.xp.proxy;

/**
 * @author zhaoxiaoping
 * @Description: 代理角色
 * @Date 2020-9-15
 **/
public class Proxy {

  private Host host;

  public Proxy() {
  }

  public Proxy(Host host) {
    this.host = host;
  }

  public void rent() {
    seeHouse();
    host.rent();
    signup();
    fare();
  }
  
  public void seeHouse(){
    System.out.println("中介带你");
  }

  public void fare() {
    System.out.println("收中介费");
  }
  
  public void signup(){
    System.out.println("签合同");
  }
}
