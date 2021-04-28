package com.xp.serializer.v2;

/**
 * @author zhaoxiaoping
 * @Description: 反序列化接口
 * @Date 2020-5-26
 **/
public interface Deserializable {

  /**
   * 反序列化操作
   *
   * @param str
   * @return
   */
  Object deserialize(String str);
}
