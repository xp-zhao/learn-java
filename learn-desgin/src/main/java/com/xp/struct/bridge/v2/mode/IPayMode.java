package com.xp.struct.bridge.v2.mode;

/**
 * @author zhaoxiaoping
 * @Description: 支付模式
 * @Date 2021-4-30
 **/
public interface IPayMode {

  /**
   * 风控校验
   *
   * @param uId 用户 id
   * @return 校验结果
   */
  boolean security(String uId);
}
