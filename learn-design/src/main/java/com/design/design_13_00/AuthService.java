package com.design.design_13_00;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟审核服务
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class AuthService {
  private static Map<String, Date> authMap = new ConcurrentHashMap<String, Date>();

  /**
   * 查询审核信息(时间)
   *
   * @param uId 用户
   * @param orderId 订单id
   * @return {@code Date}
   */
  public static Date queryAuthInfo(String uId, String orderId) {
    return authMap.get(uId.concat(orderId));
  }

  /**
   * 审核流程
   *
   * @param uId 用户id
   * @param orderId 订单id
   */
  public static void auth(String uId, String orderId) {
    authMap.put(uId.concat(orderId), new Date());
  }
}
