package com.design.design_18_00;

/**
 * 摇号服务
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class MinibusTargetService {
  /**
   * 模拟摇号，但不是摇号算法
   *
   * @param uId 用户编号
   * @return 结果
   */
  public String lottery(String uId) {
    return Math.abs(uId.hashCode()) % 2 == 0
        ? "恭喜你，编码".concat(uId).concat("在本次摇号中签")
        : "很遗憾，编码".concat(uId).concat("在本次摇号未中签或摇号资格已过期");
  }
}
