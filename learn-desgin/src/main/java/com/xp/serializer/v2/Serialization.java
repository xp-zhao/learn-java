package com.xp.serializer.v2;

/**
 * @author zhaoxiaoping
 * @Description: 序列化操作
 * @Date 2020-5-26
 **/
public class Serialization implements Serializable, Deserializable {

  @Override
  public Object deserialize(String str) {
    Object deserializedResult = "";
    System.out.println("反序列化操作");
    return deserializedResult;
  }

  @Override
  public String serialize(Object object) {
    String serializedResult = "";
    System.out.println("序列化操作");
    return serializedResult;
  }
}
