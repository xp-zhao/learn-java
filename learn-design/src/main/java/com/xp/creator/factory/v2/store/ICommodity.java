package com.xp.creator.factory.v2.store;

import java.util.Map;

/**
 * @author zhaoxiaoping
 * @Description: 奖品发放接口
 * @Date 2021-4-28
 **/
public interface ICommodity {

  /**
   * 发送奖品
   *
   * @param uId         用户 id
   * @param commodityId 奖品 id
   * @param bizId       业务 id
   * @param extMap      拓展参数
   * @throws Exception 异常
   */
  void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap)
      throws Exception;

}
