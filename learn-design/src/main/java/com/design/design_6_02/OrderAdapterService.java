package com.design.design_6_02;

/**
 * 接口适配
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public interface OrderAdapterService {
  /**
   * 是否是首单
   *
   * @param uId 用户id
   * @return boolean
   */
  boolean isFirst(String uId);
}
