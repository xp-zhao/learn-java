package com.xp.alert.v1;

/**
 * @author zhaoxiaoping
 * @Description: 消息发送接口
 * @Date 2020-5-25
 **/
public interface MessageSender {

  /**
   * 通过电话号码发送信息
   *
   * @param phone
   * @param message
   */
  void send(String phone, String message);
}
