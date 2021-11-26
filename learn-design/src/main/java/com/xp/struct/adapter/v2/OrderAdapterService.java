package com.xp.struct.adapter.v2;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-4-30
 **/
public interface OrderAdapterService {

  /**
   * 是否是首单
   *
   * @param uId 用户 id
   * @return true/false
   */
  boolean isFirst(String uId);

}
