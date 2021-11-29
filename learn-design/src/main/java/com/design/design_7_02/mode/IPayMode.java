package com.design.design_7_02.mode;

/**
 * 支付模式接口
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public interface IPayMode {
  /**
   * 安全校验
   *
   * @param uId 用户id
   * @return boolean
   */
  boolean security(String uId);
}
