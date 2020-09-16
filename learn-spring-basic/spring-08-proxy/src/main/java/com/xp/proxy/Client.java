package com.xp.proxy;


/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-15
 **/
public class Client {

  public static void main(String[] args) {
    // 房东租房
    Host host = new Host();
    // 代理，中介帮房东出租房子，但代理可以有一些附属操作
    Proxy proxy = new Proxy(host);
    // 可以不用直接面对房东，直接找中介租房
    proxy.rent();
  }
}
