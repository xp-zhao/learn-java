package com.xp.serializer.v2;

/**
 * @author zhaoxiaoping
 * @Description: 序列化接口
 * @Date 2020-5-26
 **/
public interface Serializable {

  /**
   * 序列化
   *
   * @param object
   * @return
   */
  String serialize(Object object);
}
