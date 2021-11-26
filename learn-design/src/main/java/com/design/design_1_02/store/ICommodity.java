package com.design.design_1_02.store;

import java.util.Map;

/**
 * 发奖接口
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
public interface ICommodity {
  /**
   * 发送奖品
   *
   * @param uId 用户id
   * @param commodityId 商品id
   * @param bizId 业务id
   * @param extMap 附属信息
   * @throws Exception 异常
   */
  void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap)
      throws Exception;
}
