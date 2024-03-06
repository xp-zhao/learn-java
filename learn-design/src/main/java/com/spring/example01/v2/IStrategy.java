package com.spring.example01.v2;

import com.spring.example01.RequestParam;

/**
 * 策略接口
 *
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
public interface IStrategy {
  /**
   * 判断是否匹配
   *
   * @param code
   * @return
   */
  boolean match(String code);

  /**
   * 组装参数
   *
   * @param accountId
   * @return
   */
  RequestParam buildParam(String accountId);
}
