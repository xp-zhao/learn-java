package com.xp.struct.adapter;

/**
 * @author zhaoxiaoping
 * @Description: 适配器(连接网线和电脑)
 * @Date 2020/4/27
 **/
public interface Adapter {

  /**
   * 处理请求(网线 -> USB)
   */
  void handlerRequest();
}
